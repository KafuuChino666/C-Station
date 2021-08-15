package cn.o0u0o.service.video.controller;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.video.entity.PubZone;
import cn.o0u0o.service.video.service.PubZoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Guo Yangyang
 * @version 1.0
 * @date 2021/7/26 23:19
 */
@Api("视频分区")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/video/zone")
public class PubZoneController {

    @Autowired
    public PubZoneService pubZoneService;

    @ApiOperation("添加新zone")
    @PostMapping("/")
    public Result add(@RequestBody PubZone zone) {

        boolean b = pubZoneService.add(zone);
        return b ? Result.ok().message("添加成功") : Result.err().message("添加失败!");

    }

    @ApiOperation("更新zone")
    @PutMapping("/")
    public Result update(@RequestBody PubZone zone) {
        boolean b = pubZoneService.updateZone(zone);
        return b ? Result.ok().message("更新成功") : Result.err().message("更新失败!");
    }

    @ApiOperation("删除zone")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean b = pubZoneService.deleteZone(id);
        return b ? Result.ok().message("删除成功") : Result.err().message("删除失败!");
    }
}
