package cn.o0u0o.service.security.service;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.security.entity.Role;
import cn.o0u0o.service.security.entity.vo.AddRoleVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
public interface RoleService extends IService<Role> {

    List<Role> getAll();

    IPage<Role> selectPage(Integer page, Integer limit);

    List<Role> getRoleByName(String name);

    Boolean createRoleCoverMenuResource(AddRoleVo addRoleForm);
}
