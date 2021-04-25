package cn.o0u0o.service.security.config;

import cn.o0u0o.service.security.acl.*;
import cn.o0u0o.service.security.filter.TokenAuthenticationFilter;
import cn.o0u0o.service.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;


/**
 * 核心配置类
 */
@Configuration
@EnableWebSecurity
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private DefaultPasswordEncode defaultPasswordEncode;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;

    @Autowired
    private CustomizeAccessDecisionManager accessDecisionManager;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置默认密码编码
        auth.userDetailsService(userDetailsService).passwordEncoder(defaultPasswordEncode);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()// 权限配置
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(accessDecisionManager);
                        return o;
                    }
                })
            .antMatchers("/admin/**")
                .hasRole("ADMIN")

                .anyRequest()
                .authenticated()

                .and()
                .formLogin()
                // .loginProcessingUrl("/acl/login") // 登陆地址
                .usernameParameter("username") // 修改表单默认字段
                .passwordParameter("password")

                // 登陆成功后
                .successHandler(new StaffAuthenticationSuccessHandler(tokenManager, redisTemplate))
                // 登陆失败以后
                .failureHandler(new StaffAuthenticationFailureHandler())

                .permitAll()
                .and()

                // 开启注销
                .logout()
                .logoutUrl("/acl/logout")
                .clearAuthentication(true) // 清除身份信息
                .invalidateHttpSession(true)// session失效

                // 注销处理
                .addLogoutHandler(new TokenLogoutHandler(tokenManager, redisTemplate))
                // 注销成功以后
                .logoutSuccessHandler(new StaffLogoutSuccessHandler())

                .and()
                // 令牌登陆过滤器
                // .addFilter(new TokenLoginFilter(authenticationManager(),tokenManager, redisTemplate))
                // .addFilter(new TokenAuthenticationFilter(authenticationManager(), tokenManager, redisTemplate))
                .httpBasic()
                .and()

                .exceptionHandling()
                // 异常处理，权限拒绝、登录失效
                .accessDeniedHandler(new StaffAccessDeniedHandler())
                .authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and()

                // 关闭csrf
                .csrf()
                .disable();

    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                "/api/**", "/swagger-ui.html/**", "/webjars/**", "/swagger-resources/**", "/v2/*" );
//                "/**");
    }

}
