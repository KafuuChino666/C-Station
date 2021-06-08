package cn.o0u0o.service.security.service;

import cn.o0u0o.service.security.entity.RoleMenu;
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
public interface RoleMenuService extends IService<RoleMenu> {

    List<String> getRoleById(String id);

    Boolean updataRoleByMenuId(String id, List<String> roles, Boolean batch);

    List<String> getMenuIdByRoleId(String id);

    Boolean updateByRoleId(String roleId, List<String> menus);

    int deleteBatchMenuIds(Object[] array);

    boolean deleteBatchRoleId(String id);
}
