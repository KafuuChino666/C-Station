package cn.o0u0o.service.security.entity.vo;

import lombok.Data;

/**
 * @author Guo Yangyang
 * @version 1.0
 * @date 2021/6/21 20:47
 */
@Data
public class AuthCode {

    private String username;
    private String code;

    public AuthCode() {
    }

    public AuthCode(String username, String code) {
        this.username = username;
        this.code = code;
    }
}
