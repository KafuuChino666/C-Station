package cn.o0u0o.service.security.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.security.entity.Resource;
import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.service.ResourceService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
@RestController
@CrossOrigin //跨域
@RequestMapping("/admin/acl/resource")
public class ResourceController {

    @Autowired
    public ResourceService resourceService;

    @ApiOperation("删除资源")
    @DeleteMapping("/")
    public Result removeResourceById(@RequestBody String id) {
        if (!id.isEmpty()) {
            Boolean is = resourceService.deleteById(id);
            return is ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("更新资源")
    @PutMapping("/")
    public Result updateResource(@RequestBody Resource resource) {
        boolean b = resourceService.update(resource);
        return b ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
    }

    @ApiOperation("分页获取url资源数据")
    @GetMapping("/list/{page}/{limit}")
    public Result pageResourceList(@PathVariable Integer page, @PathVariable Integer limit) {
        IPage<Resource> pageModel = resourceService.selectPage(page, limit);
        List<Resource> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return  Result.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("根据资源id/资源名称获取")
    @GetMapping("/{text}")
    public Result getResourceByText(@PathVariable String text) {
        if (!text.isEmpty()) {
            List<Resource> resources = resourceService.getByIdAndName(text);
            return Result.ok().data("rows", resources);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("添加资源")
    @PostMapping("/")
    public Result addResource(@RequestBody Resource resource) {
        if (resource != null) {
            boolean b = resourceService.save(resource);
            return b ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("获取所有资源")
    @GetMapping("/")
    public Result getList() {
        return Result.ok().data("rows", resourceService.list());
    }
}

