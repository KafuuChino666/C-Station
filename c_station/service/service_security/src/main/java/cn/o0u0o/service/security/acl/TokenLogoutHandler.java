package cn.o0u0o.service.security.acl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注销处理器
 */
public class TokenLogoutHandler implements LogoutHandler {

    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;
    private String tokenKey;

    @Autowired
    public TokenLogoutHandler(TokenManager tokenManager, RedisTemplate redisTemplate, String tokenKey) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
        this.tokenKey = tokenKey;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        //从请求头中获取token
        String token = request.getHeader(tokenKey);
        if(token != null && !token.isEmpty()) {
            //删除用户的token
            tokenManager.removeToken(token);
            //清除redis缓存服务器中的token信息
            redisTemplate.delete(tokenManager.getUserFromToken(token));
        }
    }
}