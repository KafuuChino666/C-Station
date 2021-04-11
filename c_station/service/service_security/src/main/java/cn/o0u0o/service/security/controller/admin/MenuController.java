package cn.o0u0o.service.security.controller.admin;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.security.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
@RestController
@RequestMapping("/menu")
@CrossOrigin //跨域
@RequestMapping("/admin/acl/menu")
public class MenuController {

    @Autowired
    public MenuService menuService;

    @ApiOperation("修改菜单隐藏状态")
    @PutMapping("/")
    public Result updateMenuHidden(@RequestParam String id, @RequestParam Boolean status) {
        boolean b = menuService.updateHiddenById(id, status);
        return b ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
    }

}

