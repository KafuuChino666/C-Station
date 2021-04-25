package cn.o0u0o.service.security.acl;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 权限校验
 */
@Component("accessDecisionManager")
public class CustomizeAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : collection) {

            // 当前请求所需要的权限
            String attribute = "ROLE_" + configAttribute.getAttribute();

            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority :  authorities) {
                System.out.print(authority.getAuthority());
                if (authority.getAuthority().equals(attribute)) {
                    return;
                }
            }
        }

        // 权限不足抛出异常
        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
