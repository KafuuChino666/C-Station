package cn.o0u0o.service.video.controller.api;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.oss.service.FileService;
import cn.o0u0o.service.video.entity.vo.FileUploadComplete;
import cn.o0u0o.service.video.entity.vo.VideoUpload;
import cn.o0u0o.service.video.service.VVideoService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.InputStream;

@Api("视频相关api")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/video")
@Slf4j
public class ApiVideoController {
    @Autowired
    private VVideoService vVideoService;

    @ApiOperation("视频封面上传")
    @PostMapping("/platform/cover")
    public Result uploadVideoCover(@RequestParam("file") MultipartFile file) {
        String temporaryKey = vVideoService.uploadCover(file);
        return Result.ok().data("coverTemporaryKey", temporaryKey);
    }

    @ApiOperation("视频投稿")
    @PostMapping("/platform/")
    public Result videoContribute(@RequestParam @Valid VideoUpload video) {
        boolean b = vVideoService.contribute(video);

        return Result.err().message("视频投稿失败，请稍后在试");
    }

    @ApiOperation("视频上传成功回调api")
    @PostMapping("/uploadSeccess")
    public Result uploadVideoSucceedCallbackInterface(@RequestBody String data) {
        FileUploadComplete object = JSONObject.parseObject(data, FileUploadComplete.class);
        // redisTemplate.opsForValue().set("aliyunVideoId_" + videoUploadAuth.getVideoId(), "false", 1, TimeUnit.DAYS);
        if (object != null) {
            vVideoService.uploadVideoSucceed(object);
        } else {
            log.warn("视频回调接口uploadVideoSucceedCallbackInterface()异常: data=" + data + "json=" + object.toString());
        }

        return Result.ok();
    }
}
