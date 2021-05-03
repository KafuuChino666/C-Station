package cn.o0u0o.service.video.controller;

import cn.o0u0o.service.video.service.VVideoInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caleb Chen
 * @create 2021-05-03 17:11
 */
@Api(tags = "视频信息控制类")
@RestController
@CrossOrigin //跨域
@RequestMapping("/admin/video")
public class VVideoInfoController {

    @Autowired
    private VVideoInfoService vVideoInfoService;

}
