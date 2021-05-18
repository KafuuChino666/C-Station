package cn.o0u0o.service.security.filter;

import cn.o0u0o.service.security.acl.CustomizeAccessDecisionManager;
import cn.o0u0o.service.security.acl.UrlFilterInvocationSecurityMetadataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Collection;

// @Component
public class AclAbstractSecurityInterceptor extends FilterSecurityInterceptor implements Filter {

    @Autowired
    public FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @Autowired
    public UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;

    @Override
    @Autowired
    public void setAccessDecisionManager(AccessDecisionManager accessDecisionManager) {
        super.setAccessDecisionManager(accessDecisionManager);
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return super.getSecureObjectClass();
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.urlFilterInvocationSecurityMetadataSource;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 权限校验
        FilterInvocation filterInvocation = new FilterInvocation(servletRequest, servletResponse, filterChain);
        System.out.println("1111");
        Collection<ConfigAttribute> attributes = urlFilterInvocationSecurityMetadataSource.getAttributes(filterInvocation);

        InterceptorStatusToken token = super.beforeInvocation(filterInvocation);
        try {
//            //执行下一个拦截器
            filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }

    }

}
