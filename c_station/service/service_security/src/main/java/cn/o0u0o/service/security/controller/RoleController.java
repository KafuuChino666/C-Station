package cn.o0u0o.service.security.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.entity.Role;
import cn.o0u0o.service.security.entity.vo.AddRoleVo;
import cn.o0u0o.service.security.service.RoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
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
@RequestMapping("/admin/acl/role")
public class RoleController {

    @Autowired
    public RoleService roleService;

    @GetMapping("/list")
    public Result getAll() {
        List<Role> roleList = roleService.getAll();
        return Result.ok().data("list", roleList);
    }

    @ApiOperation("分页获取角色")
    @GetMapping("/list/{page}/{limit}")
    public Result pageRoleList(@PathVariable Integer page, @PathVariable Integer limit) {
        IPage<Role> pageModel = roleService.selectPage(page, limit);
        List<Role> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return  Result.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("根据名称查询角色")
    @GetMapping("/search/{name}")
    public Result getByName(@PathVariable String name) {
        if (!name.isEmpty()) {
            List<Role> roles = roleService.getRoleByName(name);
            return Result.ok().data("rows", roles);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("根据id获取")
    @GetMapping("/{id}")
    public Result getById(@PathVariable String id) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(id.trim()).matches()) {
            Role role = roleService.getById(id);
            return Result.ok().data("row", role);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("根据Id修改角色")
    @PutMapping("/")
    public Result updateById(@RequestBody Role role) {
        boolean b = roleService.updateById(role);
        return b ? Result.ok() : Result.err().message("角色更新失败！请稍后再试~");
    }

    @ApiOperation("根据id删除")
    @DeleteMapping("/")
    public Result removeById(@RequestBody String id) {
        boolean b = roleService.removeRoleById(id);
        return b ? Result.ok() : Result.err();
    }

    @ApiOperation("创建角色")
    @PostMapping("/")
    public Result createRole(@RequestBody AddRoleVo addRoleForm) {
        Boolean b = roleService.createRoleCoverMenuResource(addRoleForm);
        return b ? Result.ok() : Result.err();
    }

    @ApiOperation("根据id更新角色状态status")
    @PutMapping("/status")
    public Result updateRoleStatusById(@RequestParam String id, @RequestParam boolean status) {
        Boolean b = roleService.updateStatusById(id, status);
        return b ? Result.ok() : Result.err();
    }
}

