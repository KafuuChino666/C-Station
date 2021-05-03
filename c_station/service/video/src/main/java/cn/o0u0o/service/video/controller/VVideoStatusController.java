package cn.o0u0o.service.video.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caleb Chen
 * @create 2021-05-03 17:11
 */
@Api(tags = "视频状态控制类")
@RestController
@CrossOrigin //跨域
@RequestMapping("/admin/c/video")
public class VVideoStatusController {
}
