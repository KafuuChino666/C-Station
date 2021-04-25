package cn.o0u0o.service.security.acl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出处理器
 */
public class TokenLogoutHandler implements LogoutHandler {

    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;

    public TokenLogoutHandler(TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        //从请求头中获取token
        String token = request.getHeader("token");
        if(!token.isEmpty()) {
            //删除用户的token
            tokenManager.removeToken(token);
            //清除redis缓存服务器中的token信息
            redisTemplate.delete(tokenManager.getUserFromToken(token));
        }
        System.out.println("清除redis缓存服务器中的token信息");
    }
}
