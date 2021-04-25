package cn.o0u0o.service.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class UserController {

    @ResponseBody
    @RequestMapping("user")
    public String user() {
        return "user";
    }
}
