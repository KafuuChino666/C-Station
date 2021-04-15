package cn.o0u0o.service.security.controller.admin;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.entity.Role;
import cn.o0u0o.service.security.service.RoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
}

