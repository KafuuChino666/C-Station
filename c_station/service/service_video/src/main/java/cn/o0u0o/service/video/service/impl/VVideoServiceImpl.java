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

        // 计算页面实际显示点赞数
        String likeNumber = videoInfoById.getLikeNumber();
        String downNumber = videoInfoById.getDownNumber();
        Long like = Long.parseLong(likeNumber);
        Long down = Long.parseLong(downNumber);
        Long likeNub = 0L;

        if((like - down) >= 0) {
            likeNub = like - down;
        }

        String likeNumb = Long.toString(likeNub);

        //获取信息
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

        // 获取 uuid
        String uuid = "269";

        // 在redis 中查询 videoId 阿里云id
        Object o = redisTemplate.opsForValue().get("aliyunVideoId_" + video.getVideoId());

        // 判断视频id是否失效/无效（视频有效期为一天）
        if (o != null) {
            // 判断视频是否上传成功
            Object is = redisTemplate.opsForHash().get(uploadSucceedVideoidKey, video.getVideoId());

            // 当is 不为空时说明视频上传成功，并带有回调数据
            if (is != null) {
                System.out.println(is.toString());
                FileUploadComplete object = JSONObject.parseObject(is.toString(), FileUploadComplete.class);

                // 判断视频封面
                String video_cover_key = "video_cover" + video.getCoverKey();
                String coverUrl = redisTemplate.opsForValue().get(video_cover_key);
                if (coverUrl == null) {
                    return false;
                }

                // 向数据库中插入相关数据
                // 创建 v_video
                Integer videoId = this.addOneVideo(uuid, coverUrl, video);
                if (videoId == 0) {
                    return false;
                }

                boolean b = false;

                // 创建 v_video_item
                Integer item_id = vVideoItemService.addVideo(videoId, object.getSize(), video);
                if (item_id == 0) throw new RuntimeException();
                // 创建 v_video_extra
                b = vVideoExtraService.addVideo(videoId, video);
                if (!b) throw new RuntimeException();
                // 清除redis Hash中的值
                redisTemplate.opsForHash().delete(uploadSucceedVideoidKey, video.getVideoId());

                // 添加视频审核
                b = vAuditStatusService.addAudit(item_id);
                if (!b) throw new RuntimeException();
                // 添加完毕
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

        // uuid + 时间戳
        String temporaryKey = UUID.randomUUID().toString();
        // 设置图片过期时间
        String video_cover_key = "video_cover" + temporaryKey;
        redisTemplate.opsForValue().set(video_cover_key, coverUrl, 1, TimeUnit.DAYS);
        redisTemplate.opsForHash().put(key, temporaryKey, coverUrl);

        return temporaryKey;
    }

    @Override
    public void uploadVideoSucceed(String videoId, String data) {
//        // 将缓存中的视频状态设置为true
//        redisTemplate.opsForValue().set("aliyunVideoId_" + object.getVideoId(), "true");
        // 将回调数据添加到数据库
        redisTemplate.opsForHash().put(uploadSucceedVideoidKey, videoId,data);
        System.out.println("回调数据设置成功");
    }

    @Override
    public Integer addOneVideo(String uuid, String coverUrl, VideoUpload video) {

        // 校验zone_id有效性
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
