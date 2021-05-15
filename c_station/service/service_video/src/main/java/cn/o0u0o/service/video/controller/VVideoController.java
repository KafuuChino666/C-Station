package cn.o0u0o.service.video.controller;

import cn.o0u0o.service.video.entity.VVideo;
import cn.o0u0o.service.video.service.VVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Caleb Chen
 * @create 2021-04-20 22:47
 */
@Api(tags = "视频控制类")
@RestController
@CrossOrigin //跨域
@RequestMapping("/admin/vVideo")
public class VVideoController {

    @Autowired
    private VVideoService vVideoService;

    @ApiOperation("查询视频总数量")
    @GetMapping("/Count")
    public Integer getVideoCount() {
        Integer count = vVideoService.getVideoCount();
        return count;
    }
    @ApiOperation("查询视频总数量")
    @GetMapping("/TypeCount")
    public Integer getZoneCountByType(@RequestParam Integer type) {
        Integer zoneCountByType = vVideoService.getZoneCountByType(type);
        return zoneCountByType;
    }
}
