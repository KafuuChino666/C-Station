package cn.o0u0o.service.security.acl;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未授权统一处理类
 */
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        Result result = Result.setResultCodeEnum(ResultCodeEnum.LOGIN_AUTH);
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONObject.toJSONString(result));
    }
}
