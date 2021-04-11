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

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
@RestController
@RequestMapping("/role-menu")
@CrossOrigin //跨域
@RequestMapping("/admin/acl/role_menu")
public class RoleMenuController {

    @Autowired
    public RoleMenuService roleMenuService;


}

