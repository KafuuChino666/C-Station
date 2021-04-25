package cn.o0u0o.service.security.acl;

import cn.o0u0o.service.security.entity.Resource;
import cn.o0u0o.service.security.service.ResourceService;
import cn.o0u0o.service.security.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    public ResourceService resourceService;

    @Autowired
    public RoleResourceService roleResourceService;

    @Autowired
    public RedisTemplate redisTemplate;

    // 用于路径匹配
    PathMatcher matcher = new AntPathMatcher();

    // 用于url截取
    Pattern pattern = Pattern.compile("[0-9]");

    /**
     * 返回该url所需要的Role权限信息
     * @param o url请求信--
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        // 登陆/注销 直接放行
        if ("/login".equals(requestUrl) || requestUrl.contains("logout")) {
            return null;
        }

        // redis缓存url所需角色
        String urlCut = urlCut(requestUrl);
        if (redisTemplate.hasKey(urlCut)) {
            List<String> url_roles = redisTemplate.opsForList().range(urlCut, 0, -1);
            if (url_roles != null ) {
                return SecurityConfig.createList(url_roles.toArray(new String[url_roles.size()]));
            }
        }

        // 如果redis缓存中没有
        // 取出所有权限控制url
        List<Resource> allResource = resourceService.list();
        for (Resource resource : allResource) {
            if (matcher.match(resource.getUrl(), requestUrl)) {
                //根据url id查出角色id
                List<String> roleNames = roleResourceService.getRoleByResourceId(resource.getId());
                // 向redis缓存添加缓存数据
                redisTemplate.opsForList().leftPushAll(urlCut, roleNames);
                return SecurityConfig.createList(roleNames.toArray(new String[roleNames.size()]));
            }
        }

        // 匹配不到则登陆
        return SecurityConfig.createList();
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    public String urlCut(String url) {
        Matcher matcher = pattern.matcher(url);
        //	判断字符串中是否包含数字
        if(matcher.find()){
            //	获取数字起始位置
            return url.substring(0, matcher.start());
        }
        return url;
    }
}
