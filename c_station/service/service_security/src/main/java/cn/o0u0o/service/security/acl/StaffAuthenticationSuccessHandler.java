package cn.o0u0o.service.security.acl;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.util.TokenManager;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class StaffAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;

    public StaffAuthenticationSuccessHandler(TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String token = tokenManager.createToken(authentication.getName());
        // 向redis中缓存用户token
        redisTemplate.opsForValue().set(authentication.getName(), authentication.getAuthorities());

        Result result = Result.ok().message("登陆成功").data("token", token).data("maxAge", TokenManager.tokenExpiration);

        log.info("用户登陆成功");

        // 登陆成功设置token
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSONObject.toJSONString(result));
    }
}
