package cn.o0u0o.service.security.service;

import cn.o0u0o.service.security.entity.RoleResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
public interface RoleResourceService extends IService<RoleResource> {

    Boolean updateByRoleId(String roleId, List<String> resource);

    List<String> getResourceIdByRoleId(String roleId);

    List<String> getRoleByResourceId(String id);
}
