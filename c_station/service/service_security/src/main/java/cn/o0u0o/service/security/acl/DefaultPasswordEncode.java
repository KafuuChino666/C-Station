package cn.o0u0o.service.security.acl;

import cn.o0u0o.service.security.util.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 密码处理
 */
@Component
public class DefaultPasswordEncode implements PasswordEncoder {
    public DefaultPasswordEncode() {
        this(-1);
    }

    public DefaultPasswordEncode(int strenfth) {

    }

    /**
     * 密码加密到MD5
     * @param charSequence
     * @return
     */
    @Override
    public String encode(CharSequence charSequence) {
        return MD5.encrypt(charSequence.toString());
    }

    /**
     * MD5密文比对
     * @param charSequence 明文密码(前端密文解密到明文)
     * @param encodedPassword MD5密码(数据库)
     * @return
     */
    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword) {
        System.out.println("原文加密:" + MD5.encrypt(charSequence.toString()));
        return encodedPassword.equals(MD5.encrypt(charSequence.toString()));
    }
}
