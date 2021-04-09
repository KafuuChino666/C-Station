package cn.o0u0o.service.security.controller.admin;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.service.StaffService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @Autowired
    public StaffService staffService;

    @ApiOperation("员工登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result staffLogin() {
        return Result.ok().data("token","admin");
    }

    @GetMapping("/info")
    public Result info() {
        return Result.ok()
                .data("roles","[admin]")
                .data("name","admin")
                .data("avatar","https://mcsql-002.oss-cn-beijing.aliyuncs.com/www.png");
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
}

