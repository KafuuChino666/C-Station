package cn.o0u0o.service.admin.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-23
 */
@RestController
@RequestMapping("/u-user")
public class UUserController {

    @GetMapping(value = "/")
    public void selectUserByInfo() {

    }

}

