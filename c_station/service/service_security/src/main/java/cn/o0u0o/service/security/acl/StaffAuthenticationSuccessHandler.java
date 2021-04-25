package cn.o0u0o.service.security.acl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        redisTemplate.opsForValue().set(authentication.getName(), authentication.getAuthorities());

        //ResponseUtil.out(res, R.ok().data("token", token));
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge((int)TokenManager.tokenExpiration);
        httpServletResponse.addCookie(cookie);
        System.out.println("登陆成功,设置token");
    }
}
