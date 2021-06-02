package cn.o0u0o.service.security.controller;

import cn.o0u0o.common.exception.operate.SelectException;
import cn.o0u0o.common.response.Result;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class UserController {

    @ResponseBody
    @RequestMapping("user")
    public String user() throws Exception {
        throw new SelectException(Result.err().code(20001).message("123"));
//        return "user";
    }
}
