package cn.o0u0o.service.security.mapper;

import cn.o0u0o.service.security.entity.RoleResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
public interface RoleResourceMapper extends BaseMapper<RoleResource> {

    List<String> getResourceIdByRoleId(String roleId);

    List<String> getRoleByResourceId(String id);
}
