package cn.o0u0o.service.security.filter;

import cn.o0u0o.service.security.acl.TokenManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * 授权过滤
 */
public class TokenAuthenticationFilter extends BasicAuthenticationFilter {

    private RedisTemplate redisTemplate;
    private TokenManager tokenManager;

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager,
                                     TokenManager tokenManager, RedisTemplate redisTemplate) {
        super(authenticationManager);
        this.redisTemplate = redisTemplate;
        this.tokenManager = tokenManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //判断路径
        if(request.getRequestURI().indexOf("admin") == -1) {
            chain.doFilter(request, response);
            return;
        }

        System.out.println("doFilterInternal()");
        UsernamePasswordAuthenticationToken authentication = null;
        try {
            authentication = getAuthentication(request);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            System.out.println(authentication + "为空！");
        }
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

        //获取请求头中的token
//        String token = request.getHeader("token");
        String token = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
                break;
            }
        }

        System.out.println("获取请求头中的token()" + token);
        //判断token存在或者不为空字符串
        if (token != null && !"".equals(token.trim())) {
            System.out.println("存在token= " + token);
            String userName = tokenManager.getUserFromToken(token);
            System.out.println("username" + userName);


            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) redisTemplate.opsForValue().get(userName);

            if (!userName.isEmpty()) {
                return new UsernamePasswordAuthenticationToken(userName, token,
                        authorities);
            }
            return null;
        }
        return null;
    }

}
