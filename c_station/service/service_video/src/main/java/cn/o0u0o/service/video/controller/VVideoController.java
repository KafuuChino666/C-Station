package cn.o0u0o.service.video.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.video.entity.vo.VideoUpload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-17
 */
@Api("视频相关api")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/video")
public class VVideoController {

    @ApiOperation("视频投稿")
    @PostMapping("/platform/")
    public Result videoContribute(@RequestBody @Valid VideoUpload video) {
        System.out.println(video);
        return Result.err();
    }

}

