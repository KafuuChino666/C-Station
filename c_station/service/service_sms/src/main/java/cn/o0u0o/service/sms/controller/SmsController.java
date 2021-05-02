package cn.o0u0o.service.sms.controller;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.sms.service.SmsService;
import com.dingxianginc.ctu.client.CaptchaClient;
import com.dingxianginc.ctu.client.model.CaptchaResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/sms")
@Api(description = "短信管理")
@CrossOrigin //跨域
public class SmsController {

}
