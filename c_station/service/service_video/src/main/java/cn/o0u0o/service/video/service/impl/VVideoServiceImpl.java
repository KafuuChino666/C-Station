package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.oss.service.FileService;
import cn.o0u0o.service.video.entity.VVideo;
import cn.o0u0o.service.video.entity.VVideoStatus;
import cn.o0u0o.service.video.entity.vo.*;
import cn.o0u0o.service.video.mapper.VVideoMapper;
import cn.o0u0o.service.video.service.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service
public class VVideoServiceImpl extends ServiceImpl<VVideoMapper, VVideo> implements VVideoService {

    @Autowired
    private VVideoMapper vVideoMapper;

    @Autowired
    private PubZoneService pubZoneService;

    @Autowired
    private VVideoItemService vVideoItemService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private FileService fileService;

    @Autowired
    private VAuditStatusService vAuditStatusService;

    @Autowired
    private VVideoExtraService vVideoExtraService;

    private static final String uploadSucceedVideoidKey = "uploadSucceedVideoID";

    @Override
    public IPage<TableData> selectVideoByTerm(Integer page, Integer limit, Integer videoId, String videoTitle, Integer authorId, Date startTime, Date endTime, String playNub, Integer videoStatus) {
        Page<QueryForm> pageParam = new Page<>(page, limit);
        return vVideoMapper.selectVideoByTerm(pageParam, videoId, videoTitle, authorId, startTime, endTime, playNub, videoStatus);
    }

    @Override
    public VideoInfoResult getVideoInfoById(Integer videoId) {
        VideoInfoForm videoInfoById = vVideoMapper.getVideoInfoById(videoId);

        // ?????????????????????????????????
        String likeNumber = videoInfoById.getLikeNumber();
        String downNumber = videoInfoById.getDownNumber();
        Long like = Long.parseLong(likeNumber);
        Long down = Long.parseLong(downNumber);
        Long likeNub = 0L;

        if((like - down) >= 0) {
            likeNub = like - down;
        }

        String likeNumb = Long.toString(likeNub);

        //????????????
        Integer authorId = videoInfoById.getAuthorId();
        String userName = videoInfoById.getUserName();
        String videoTitle = videoInfoById.getVideoTitle();
        String videoBrief = videoInfoById.getVideoBrief();
        Date gmtCreate = videoInfoById.getGmtCreate();
        String playNub = videoInfoById.getPlayNub();
        String videoPnumb = videoInfoById.getVideoPnumb();
        Integer videoCoin = videoInfoById.getVideoCoin();
        List<String> zoneType = videoInfoById.getZoneType();
        Integer videoStatus = videoInfoById.getVideoStatus();
        String videoLocation = videoInfoById.getVideoLocation();

        VideoInfoResult videoInfoResult
                = new VideoInfoResult(videoId, authorId, userName, videoTitle, videoBrief, gmtCreate, playNub, videoPnumb, videoCoin, likeNumb, zoneType, videoStatus, videoLocation);

        return videoInfoResult;
    }

    @Override
    public List<VVideoStatus> selectAllVideoStatus() {
        List<VVideoStatus> statusList = vVideoMapper.selectAllVideoStatus();
        return statusList;
    }

    @Override
    @Transactional
    public boolean contribute(VideoUpload video) {

        // ?????? uuid
        String uuid = "269";

        // ???redis ????????? videoId ?????????id
        Object o = redisTemplate.opsForValue().get("aliyunVideoId_" + video.getVideoId());

        // ????????????id????????????/????????????????????????????????????
        if (o != null) {
            // ??????????????????????????????
            Object is = redisTemplate.opsForHash().get(uploadSucceedVideoidKey, video.getVideoId());

            // ???is ????????????????????????????????????????????????????????????
            if (is != null) {
                System.out.println(is.toString());
                FileUploadComplete object = JSONObject.parseObject(is.toString(), FileUploadComplete.class);

                // ??????????????????
                String video_cover_key = "video_cover" + video.getCoverKey();
                String coverUrl = redisTemplate.opsForValue().get(video_cover_key);
                if (coverUrl == null) {
                    return false;
                }

                // ?????????????????????????????????
                // ?????? v_video
                Integer videoId = this.addOneVideo(uuid, coverUrl, video);
                if (videoId == 0) {
                    return false;
                }

                boolean b = false;

                // ?????? v_video_item
                Integer item_id = vVideoItemService.addVideo(videoId, object.getSize(), video);
                if (item_id == 0) throw new RuntimeException();
                // ?????? v_video_extra
                b = vVideoExtraService.addVideo(videoId, video);
                if (!b) throw new RuntimeException();
                // ??????redis Hash?????????
                redisTemplate.opsForHash().delete(uploadSucceedVideoidKey, video.getVideoId());

                // ??????????????????
                b = vAuditStatusService.addAudit(item_id);
                if (!b) throw new RuntimeException();
                // ????????????
                return true;
            }
        }

        return false;
    }

    @Override
    public String uploadCover(MultipartFile file) {
        String key = "temporary_video_cover";

        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (Exception e) {
            throw new RuntimeException(ResultCodeEnum.FILE_UPLOAD_ERROR.toString());
        }
        String filename = file.getOriginalFilename();
        String coverUrl = fileService.upload(inputStream, "videoCover", filename);

//        System.out.println(coverUrl);

        // uuid + ?????????
        String temporaryKey = UUID.randomUUID().toString();
        // ????????????????????????
        String video_cover_key = "video_cover" + temporaryKey;
        redisTemplate.opsForValue().set(video_cover_key, coverUrl, 1, TimeUnit.DAYS);
        redisTemplate.opsForHash().put(key, temporaryKey, coverUrl);

        return temporaryKey;
    }

    @Override
    public void uploadVideoSucceed(String videoId, String data) {
//        // ????????????????????????????????????true
//        redisTemplate.opsForValue().set("aliyunVideoId_" + object.getVideoId(), "true");
        // ?????????????????????????????????
        redisTemplate.opsForHash().put(uploadSucceedVideoidKey, videoId,data);
        System.out.println("????????????????????????");
    }

    @Override
    public Integer addOneVideo(String uuid, String coverUrl, VideoUpload video) {

        // ??????zone_id?????????
        Boolean b = pubZoneService.isZoneIdValid(video.getZoneId()[1]);
        Integer id = 0;
        if (b) {
            VVideo vVideo = new VVideo(uuid, video.getZoneId()[1], coverUrl, video.getVideoTitle(), video.getVideoBrief(), 0);
            this.save(vVideo);
            return Integer.valueOf(vVideo.getId());
//            id = vVideoMapper.insertOneVideo(uuid, video.getZoneId()[1], video.getCoverUrl(), video.getVideoTitle(), video.getVideoBrief(), 0);
        }
        return id;
    }


}
