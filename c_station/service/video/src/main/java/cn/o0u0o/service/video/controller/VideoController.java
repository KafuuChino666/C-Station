package cn.o0u0o.service.video.controller;

import cn.o0u0o.service.video.entity.VVideo;
import cn.o0u0o.service.video.service.VVideoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caleb Chen
 * @create 2021-04-20 22:47
 */
@RestController
@CrossOrigin //跨域
@RequestMapping("/admin/c/video")
public class VideoController {

    @Autowired
    private VVideoService vVideoService;

    @ApiOperation("查询视频总数量")
    @GetMapping("/vcount")
    public Integer getVideoCount() {
        Integer countbyId = vVideoService.getVideoCountbyId();
        return countbyId;
    }
}
