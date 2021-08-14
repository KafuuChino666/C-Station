package cn.o0u0o.service.security.acl;

import com.alibaba.fastjson.JSONObject;
import cn.o0u0o.common.response.Result;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StaffAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Result result = Result.err();
        if (e instanceof AccountExpiredException) {
            result.message("账号过期");
        } else if (e instanceof BadCredentialsException) {
            result.message("密码错误");
        } else if (e instanceof CredentialsExpiredException) {
            result.message("密码过期");
        } else if (e instanceof DisabledException) {
            result.message("账号不可用");
        } else if (e instanceof LockedException) {
            result.message("账号锁定");
        } else if (e instanceof InternalAuthenticationServiceException || e instanceof UsernameNotFoundException) {
            result.message("用户不存在");
        }else{
            result.message("其他错误");
        }

        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONObject.toJSONString(result));
    }
}
