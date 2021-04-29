package cn.o0u0o.service.security.acl;

import cn.o0u0o.service.security.service.StaffService;
import cn.o0u0o.service.security.util.RSABase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public class StaffAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    public UserDetailsService userDetailsService;

    @Autowired
    public DefaultPasswordEncode defaultPasswordEncode;

    @Autowired
    public RSABase rsaBase;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        // new LoginService().loadUserByUsername()
        UserDetails user = userDetailsService.loadUserByUsername(username);

        // 私钥解密
        String textPassword = rsaBase.privKeyDectytData(password, rsaBase.getPriveatKey());

        if (!defaultPasswordEncode.matches(textPassword, user.getPassword())) {
            throw new CredentialsExpiredException("密码错误!");
        }

        //获取用户权限信息
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();


        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
