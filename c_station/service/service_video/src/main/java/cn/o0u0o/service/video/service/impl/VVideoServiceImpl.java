package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.oss.service.FileService;
import cn.o0u0o.service.video.entity.VVideo;
import cn.o0u0o.service.video.entity.VVideoStatus;
import cn.o0u0o.service.video.entity.vo.*;
import cn.o0u0o.service.video.mapper.VVideoMapper;
import cn.o0u0o.service.video.service.PubZoneService;
import cn.o0u0o.service.video.service.VVideoItemService;
import cn.o0u0o.service.video.service.VVideoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;


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
    public boolean contribute(VideoUpload video) {

        // 获取 uuid
        String uuid = "2697287132";

        // 在redis 中查询 videoId 阿里云id
        Object o = redisTemplate.opsForValue().get("aliyunVideoId_" + video.getVideoId());

        // 判断视频id是否失效/无效（视频有效期为一天）
        if (o != null) {
            // 判断视频是否上传成功
            Object is = redisTemplate.opsForHash().get(uploadSucceedVideoidKey, video.getVideoId());

            // 当is 不为空时说明视频上传成功，并带有回调数据
            if (is != null) {
                FileUploadComplete object = (FileUploadComplete)is;

                // 向数据库中插入相关数据
                // 创建 v_video
                Long videoId = this.addOneVideo(uuid, video);
                if (videoId == 0) {
                    return false;
                }

                // 创建 v_video_item
                vVideoItemService.addVideo(videoId, video);
                // 创建 v_video_extra

                // 清除redis Hash中的值

                // 添加完毕

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

        System.out.println(coverUrl);

        // uuid + 时间戳
        String temporaryKey = UUID.randomUUID().toString() + "_" + new Date().getTime();
        redisTemplate.opsForHash().put(key, temporaryKey, coverUrl);

        return temporaryKey;
    }

    @Override
    public void uploadVideoSucceed(FileUploadComplete object) {
//        // 将缓存中的视频状态设置为true
//        redisTemplate.opsForValue().set("aliyunVideoId_" + object.getVideoId(), "true");
        // 将回调数据添加到数据库
        redisTemplate.opsForHash().put(uploadSucceedVideoidKey, object.getVideoId(), object);
    }

    @Override
    public Long addOneVideo(String uuid, VideoUpload video) {

        // 校验zone_id有效性
        Boolean b = pubZoneService.isZoneIdValid(video.getZoneId()[1]);
        long id = 0L;
        if (b) {
            id = vVideoMapper.insertOneVideo(uuid, video.getZoneId()[1], video.getCoverUrl(), video.getVideoTitle(), video.getVideoBrief(), 0);
        }
        return id;
    }

}
