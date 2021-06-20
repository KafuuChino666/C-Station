package cn.o0u0o.service.security.controller;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.security.service.AuthenticationService;
import cn.o0u0o.service.security.util.CaptchaUtil;
import cn.o0u0o.service.security.util.RSABase;
import com.alibaba.fastjson.JSONObject;
import com.dingxianginc.ctu.client.CaptchaClient;
import com.dingxianginc.ctu.client.model.CaptchaResponse;
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

    @Autowired
    public CaptchaClient captchaClient;

    @Autowired
    public AuthenticationService authenticationService;

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

    @ApiOperation("发送验证码")
    @PostMapping("/send")
    public Result send(@RequestParam String username, @RequestParam String token) {
        //校验token
        try {
            CaptchaResponse response = captchaClient.verifyToken(token);
            if (response.getResult()) {
                //token验证通过，继续其他流程
                boolean is = authenticationService.sendCaptcha(username);
                return is ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.SMS_SEND_ERROR);
            } else {
                //token验证失败
                return Result.setResultCodeEnum(ResultCodeEnum.CODE_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.ok();
    }
}
