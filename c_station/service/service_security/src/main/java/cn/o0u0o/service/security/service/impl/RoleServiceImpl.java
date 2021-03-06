package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.Role;
import cn.o0u0o.service.security.entity.vo.AddRoleVo;
import cn.o0u0o.service.security.mapper.RoleMapper;
import cn.o0u0o.service.security.mapper.RoleMenuMapper;
import cn.o0u0o.service.security.mapper.RoleResourceMapper;
import cn.o0u0o.service.security.service.RoleMenuService;
import cn.o0u0o.service.security.service.RoleResourceService;
import cn.o0u0o.service.security.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    public RoleMapper roleMapper;

    @Autowired
    public RoleResourceService roleResourceServicer;

    @Autowired
    public RoleMenuService roleMenuService;

    @Override
    public List<Role> getAll() {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");
        return roleMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<Role> selectPage(Integer page, Integer limit) {
        return roleMapper.selectPage(new Page<Role>(page, limit), null);
    }

    @Override
    public List<Role> getRoleByName(String name) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        return roleMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public Boolean createRoleCoverMenuResource(AddRoleVo addRoleForm) {
        // 创建Role 返回role_id
        int num = roleMapper.createRole(addRoleForm.getRoleInfo());

        // id存在时
        if (num == 1) {
            Role role = addRoleForm.getRoleInfo();
            boolean b1 = true, b2 = true;
            // 根据role_id绑定菜单
            if(addRoleForm.getMenuList().size() != 0) {
                b1 = roleMenuService.updateByRoleId(role.getId(), addRoleForm.getMenuList());
            }
            // 根据role_id绑定资源
            if (addRoleForm.getResourceList().size() != 0) {
                b2 = roleResourceServicer.updateByRoleId(role.getId(), addRoleForm.getResourceList());
            }
            return b1 && b2;
        }

        return false;
    }

    @Override
    public Boolean updateStatusById(String id, boolean status) {
        return roleMapper.updateStatusById(id, status);
    }

    @Transactional
    @Override
    public boolean removeRoleById(String id) {
        // id 角色id
        boolean b;
        // 1. 删除RoleMenu关系表数据
        b = roleMenuService.deleteBatchRoleId(id);

        // 2. 删除RoleResource关系表中的数据
        b = roleResourceServicer.deleteBatchRoleId(id);

        // 3. 删除角色
        b = this.removeById(id);

        return b;
    }
}
