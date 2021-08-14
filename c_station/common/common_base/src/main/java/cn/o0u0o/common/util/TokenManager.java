package cn.o0u0o.common.util;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * token 操作工具类
 */
@Component
public class TokenManager {

    public static long tokenExpiration = 24*60*60*7000;
    private String tokenStringKey = "jfdblgkjhsdjkfhfgj";

    @Value("${acl.token.key:ACL-Token}")
    private String tokenKey;

    /**
     * 创建一个token
     * @param username
     * @return
     */
    public String createToken(String username) {
        return Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+tokenExpiration))
                .signWith(SignatureAlgorithm.HS256, tokenStringKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
    }

    /**
     * 获取用户表单中的token
     * @param token
     * @return
     */
    public String getUserFromToken(String token) {
        return Jwts.parser().setSigningKey(tokenStringKey)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    /**
     * 删除用户token
     */
    public void removeToken(String token) {

    }

    public String getUserNameByToken(HttpServletRequest request) {
        String token = request.getHeader(tokenKey);
        if (token == null || token.isEmpty()) return null;
        return getUserFromToken(token);
    }
}
