package cn.o0u0o.service.security.controller.admin;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.security.entity.Role;
import cn.o0u0o.service.security.service.StaffRoleService;
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
@RequestMapping("/admin/acl/staff-role")
public class StaffRoleController {

    @Autowired
    public StaffRoleService staffRoleService;

    @ApiOperation("获取员工角色")
    @GetMapping("/{id}")
    public Result getRoleIdStatusById(@PathVariable Integer id) {
        if (id > 0) {
            List<String> roles = staffRoleService.getByStatusId(id);
            return Result.ok().data("roles", roles);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("更新员工角色")
    @PutMapping("/")
    public Result updateRolesById(@RequestParam Integer id, @RequestBody List<Integer> roles) {
        Integer i = staffRoleService.updateRolesById(id, roles);
        if (i == 1) {
            return Result.ok();
        }
        return Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
    }
}

