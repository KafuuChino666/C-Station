package cn.o0u0o.service.video.controller.api;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.video.entity.PubZone;
import cn.o0u0o.service.video.entity.vo.ZoneHierarchy;
import cn.o0u0o.service.video.service.PubZoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-23
 */
@Api("视频分区")
@CrossOrigin //跨域
@RestController
@RequestMapping("/api/video/zone")
public class ApiPubZoneController {

    @Autowired
    public PubZoneService pubZoneService;

    @ApiOperation("获取父节点")
    @GetMapping("/root")
    public Result getAllRootNode() {
        List<PubZone> pubZones = pubZoneService.getNodeByLevel("0");
        if (pubZones != null) {
            return Result.ok().data("zones", pubZones);
        }
        return Result.err();
    }

    @ApiOperation("获取子节点")
    @GetMapping("/child/{parentId}")
    public Result getChildByParentId(@PathVariable Integer parentId) {

        List<PubZone> pubZones = pubZoneService.getChildByParentId(parentId);
        if (pubZones != null) {
            return Result.ok().data("zones", pubZones);
        }
        return Result.err();
    }

    @ApiOperation("获取zone层级结构")
    @GetMapping("/hierarchy")
    public Result getZoneHierarchyStructure() {
        List<ZoneHierarchy> pubZones = pubZoneService.getZoneHierarchyStructure();
        return Result.ok().data("zone", pubZones);
    }

    @ApiOperation("校验zone Tile合法性")
    @GetMapping("/verify/title/{title}")
    public Result verifyTitle(@PathVariable String title) {

        if (!title.isEmpty()) {
            boolean b = pubZoneService.verifyTitleRepetition(title);
            return !b ? Result.ok().data("validate", true) : Result.err().message("title重复!");
        }
        return Result.err();
    }

}

