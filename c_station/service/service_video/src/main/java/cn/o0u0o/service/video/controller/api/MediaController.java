package cn.o0u0o.service.video.controller.api;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.video.entity.vo.VideoUploadAuth;
import cn.o0u0o.service.video.service.MediaService;
import cn.o0u0o.service.video.service.VVideoItemService;
import cn.o0u0o.service.video.service.VVideoService;
import com.aliyun.vod20170321.models.GetVideoInfoResponse;
import com.aliyun.vod20170321.models.ListSnapshotsResponse;
import com.aliyuncs.exceptions.ClientException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Api("阿里云视频点播")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/video/media")
@Slf4j
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @Autowired
    private VVideoItemService vVideoItemService;

    @ApiOperation("获取视频播放凭证")
    @GetMapping("get-play-auth/{videoItemId}")
    public Result getPlayAuthByVideoId(@ApiParam("阿里云视频文件的id") @PathVariable Integer videoItemId) {

        try{
            // 查出videoSourceId aliyun ID
            String videoSourceId = vVideoItemService.getLocationById(videoItemId);
            if(videoSourceId.isEmpty()) {
                return Result.err().message("无此视频！");
            }
            String playAuth = mediaService.getPlayAuth(videoSourceId);
            return  Result.ok().message("获取播放凭证成功").data("playAuth", playAuth).data("vid", videoSourceId);
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new RuntimeException(String.valueOf(ResultCodeEnum.FETCH_PLAYAUTH_ERROR));
        }
    }

    @ApiOperation("视频上传")
    @PostMapping("upload")
    public Result uploadVideo(@ApiParam(name = "file", value = "文件", required = true) @RequestParam("file") MultipartFile file) {

        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String videoId = mediaService.uploadVideo(inputStream, originalFilename);
            return Result.ok().message("视频上传成功").data("videoId", videoId);
        } catch (IOException e) {
            log.error(ExceptionUtils.getMessage(e));
        }
        return Result.setResultCodeEnum(ResultCodeEnum.VIDEO_UPLOAD_TOMCAT_ERROR);
    }

    @ApiOperation("获取上传地址和凭证")
    @GetMapping("get-upload-auth/{uuid}")
    public Result getUploadAuth(@PathVariable String uuid) {
        try {
            VideoUploadAuth videoUploadAuth = mediaService.getUploadAuth(uuid);
            return videoUploadAuth != null ? Result.ok().data("auth", videoUploadAuth) : Result.err().message("获取上传凭证失败请稍后在试!");
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return Result.err().message("获取上传凭证失败请稍后在试!");
    }

    @ApiOperation("根据阿里云视频id获取封面列表")
    @GetMapping("get-video-cove/{videoId}")
    public Result getVideoCoveByVideoId(@PathVariable String videoId) {
        GetVideoInfoResponse videoCove = mediaService.getVideoCove(videoId);
        if (videoCove != null) {
            System.out.println(videoCove.getBody().video.snapshots.snapshot);
            return Result.ok().data("cove", videoCove.getBody().video.snapshots.snapshot);
        }
        return Result.err();
    }

    @ApiOperation("获取视频的雪碧图原始图")
    @GetMapping("/get-sprite-origin-snapshot/{videoItemId}/{pageSize}/{pageNo}")
    public Result getSpriteOriginSnapshot(@PathVariable Integer pageSize, @PathVariable Integer pageNo, @PathVariable Integer videoItemId) {

        if (pageSize > 0 && pageNo > 0) {
            ListSnapshotsResponse listSnapshotsResponse = mediaService.spriteOriginSnapshot(pageSize, pageNo, videoItemId);
            return Result.ok().data("mediaSnapshot", listSnapshotsResponse.getBody().mediaSnapshot);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }
}
