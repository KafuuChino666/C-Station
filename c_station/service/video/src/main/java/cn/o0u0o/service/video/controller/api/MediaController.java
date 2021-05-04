package cn.o0u0o.service.video.controller.api;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.video.service.MediaService;
import cn.o0u0o.service.video.service.VVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("阿里云视频点播")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/video/media")
@Slf4j
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @Autowired
    private VVideoService vVideoService;

    @GetMapping("get-play-auth/{videoId}")
    public Result getPlayAuth(@ApiParam("视频的id") @PathVariable String videoId) {

        try{
            String videoSource = vVideoService.getVideoSource(videoId);
            if (videoSource == null || videoSource.isEmpty()) {
                return Result.setResultCodeEnum(ResultCodeEnum.FETCH_PLAYAUTH_ERROR);
            }
            String playAuth = mediaService.getPlayAuth(videoSource);
            return  Result.ok().message("获取播放凭证成功").data("playAuth", playAuth);
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new RuntimeException(String.valueOf(ResultCodeEnum.FETCH_PLAYAUTH_ERROR));
        }
    }

}
