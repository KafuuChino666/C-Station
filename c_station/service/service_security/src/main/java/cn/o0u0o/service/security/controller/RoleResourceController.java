package cn.o0u0o.service.security.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.security.service.RoleResourceService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/admin/acl/role-resource")
public class RoleResourceController {

    @Autowired
    public RoleResourceService roleResourceService;

    @ApiOperation("更新角色资源")
    @PutMapping("/{roleId}")
    public Result updateRoleResourceByRoleId(@PathVariable String roleId, @RequestBody List<String> resource) {
        Boolean b = roleResourceService.updateByRoleId(roleId, resource);
        return b ? Result.ok() : Result.err();
    }

    @ApiOperation("根据角色Id获取资源列表")
    @GetMapping("/resource/{roleId}")
    public Result getResourceByRoleId(@PathVariable String roleId) {
        List<String> list = roleResourceService.getResourceIdByRoleId(roleId);
        return Result.ok().data("rows", list);
    }

}

