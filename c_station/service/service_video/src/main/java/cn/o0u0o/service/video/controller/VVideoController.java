package cn.o0u0o.service.video.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.video.entity.vo.VideoUpload;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-17
 */
@RestController
@RequestMapping("/api/video")
public class VVideoController {

    @ApiOperation("视频投稿")
    @PostMapping("/platform/")
    public Result videoContribute(@RequestParam VideoUpload videoUpload) {
        System.out.println(videoUpload);
        return Result.err();
    }

}

