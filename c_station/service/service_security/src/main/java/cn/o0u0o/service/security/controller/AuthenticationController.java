package cn.o0u0o.service.security.controller;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.security.util.CaptchaUtil;
import cn.o0u0o.service.security.util.RSABase;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 身份验证处理器
 */
@RestController
@CrossOrigin //跨域
@RequestMapping("/acl/")
public class AuthenticationController {

    @Autowired
    public RSABase rsaBase;

    @ApiOperation("生成公钥")
    @GetMapping("/publickey")
    public Result getPublicKey() {
        String publicKey = rsaBase.getPublicKey();
        return Result.ok().data("publicKey",publicKey);
    }

    @ApiOperation("获取验证码图片")
    @GetMapping("/captcha")
    public void getCaptcha(HttpServletResponse response) {
        try {
            response.setContentType("image/png");
            String random = CaptchaUtil.random();
            CaptchaUtil.outputImage(random,response.getOutputStream());
        } catch (IOException e) {
            // 返回友好信息
            response.setContentType("text/json;charset=utf-8");
            try {
                response.getWriter().write(JSONObject.toJSONString(Result.err().message("验证码生成错误")));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
