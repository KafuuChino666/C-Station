package cn.o0u0o.service.security.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.security.acl.TokenManager;
import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.entity.vo.StaffVo;
import cn.o0u0o.service.security.service.StaffService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/admin/acl/staff")
public class StaffController {

    @Value("${acl.token.key:ACL-Token}")
    private String tokenKey;
    
    @Autowired
    public StaffService staffService;

    @Autowired
    public TokenManager tokenManager;

    @ApiOperation("员工登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result staffLogin() {
        return Result.ok().data("token","admin");
    }

    @GetMapping("/menu")
    public Result getMenu(HttpServletRequest request) {
        String token = request.getHeader(tokenKey);
        if (token == null || token.isEmpty()) return Result.err();

        List<Menu> menus = staffService.getMenusByUserName(tokenManager.getUserFromToken(token));
        return Result.ok().data("menus", menus);
    }

    @GetMapping("/info")
    public Result info(HttpServletRequest request) {

        String token = request.getHeader(tokenKey);
        if (token == null || token.isEmpty()) return Result.err();
        String username = tokenManager.getUserFromToken(token);
        Staff staff = staffService.getByUserName(username);

        return Result.ok()
                .data("roles","[admin]")
                .data("name",staff.getNickName())
                .data("avatar",staff.getIcon());
    }

    @ApiOperation("根据id查找员工")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getStaffById(@PathVariable Integer id) {
        if (id > 0) {
            Staff staff = staffService.getById(id);
            return Result.ok().data("rows", staff);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("分页员工列表")
    @GetMapping("/list/{page}/{limit}")
    public Result pageStaffList(
            @ApiParam(value = "当前页码", required = true) @PathVariable Long page,
            @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit){

        IPage<Staff> pageModel = staffService.selectPage(page, limit);
        List<Staff> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return  Result.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("更新用户状态")
    @PutMapping("/update/status")
    public Result updateStaffStatusById(
            @RequestParam("id") Integer id, @RequestParam("status") Boolean status) {
        staffService.updateStatusById(id,status);
        return Result.ok();
    }

    @ApiOperation("添加新员工")
    @PutMapping("/")
    public Result add(@RequestBody StaffVo staff) {
        boolean b = staffService.createStaff(staff);
        return b ? Result.ok().message("员工添加成功！") : Result.err().message("员工添加失败！");
    }

    @ApiOperation("校验用户名")
    @GetMapping("/validate/{username}")
    public Result validateUserName(@PathVariable String username) {
        Boolean b = staffService.validateUserName(username);
        return Result.ok().data("validate", b);
    }
}

