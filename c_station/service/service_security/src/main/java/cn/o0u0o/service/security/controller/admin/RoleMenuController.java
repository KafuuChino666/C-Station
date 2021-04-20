package cn.o0u0o.service.security.controller.admin;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.security.entity.Resource;
import cn.o0u0o.service.security.service.RoleMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

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
@RequestMapping("/admin/acl/role_menu")
public class RoleMenuController {

    @Autowired
    public RoleMenuService roleMenuService;

    @ApiOperation("根据Menu id获取Roles")
    @GetMapping("/{id}")
    public Result getRolesMenuById(@PathVariable String id) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(id.trim()).matches()) {
            List<String> roleIds =  roleMenuService.getRoleById(id);
            return Result.ok().data("rows", roleIds);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("修改菜单角色")
    @PutMapping("/")
    public Result updataMenuRole(@RequestParam String id, @RequestBody List<String> roles) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(id.trim()).matches()) {
            Boolean b = roleMenuService.updataRoleByMenuId(id, roles);
            return b ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
        }

        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("根据role Id获取菜单id")
    @GetMapping("/menu/{id}")
    public Result getMenuByRoleId(@PathVariable String id) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(id.trim()).matches()) {
            List<String> menus = roleMenuService.getMenuIdByRoleId(id);
            return Result.ok().data("rows", menus);
        }
        return Result.err();
    }

    @ApiOperation("根据角色ID更新菜单")
    @PutMapping("/role")
    public Result updateMenuByRoleId(@RequestParam String roleId, @RequestBody List<String> menus) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(roleId.trim()).matches()) {
            Boolean b = roleMenuService.updateByRoleId(roleId, menus);
            return b ? Result.ok() : Result.err();
        }
        return Result.err();
    }
}

