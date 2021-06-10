package cn.o0u0o.service.security.acl;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * token 操作工具类
 */
@Component
public class TokenManager {

    public static long tokenExpiration = 24*60*60*7000;
    private String tokenStringKey = "jfdblgkjhsdjkfhfgj";

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
}
