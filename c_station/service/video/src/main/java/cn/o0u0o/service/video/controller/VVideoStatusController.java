package cn.o0u0o.service.video.controller;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.video.entity.VVideoStatus;
import cn.o0u0o.service.video.service.VVideoStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-05-03 17:11
 */
@Api(tags = "视频状态控制类")
@RestController
@CrossOrigin //跨域
@RequestMapping("/admin/video")
public class VVideoStatusController {

    @Autowired
    private VVideoStatusService vVideoStatusService;

    @ApiOperation("获取所有视频状态")
    @GetMapping(value = "/status")
    public Result selectAllVideoStatus() {
        List<VVideoStatus> statusList = vVideoStatusService.selectAllVideoStatus();
        return Result.ok().data("statusList", statusList);
    }

}