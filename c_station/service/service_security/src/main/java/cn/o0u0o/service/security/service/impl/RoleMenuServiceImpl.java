package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.RoleMenu;
import cn.o0u0o.service.security.mapper.RoleMenuMapper;
import cn.o0u0o.service.security.service.MenuService;
import cn.o0u0o.service.security.service.RoleMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Autowired
    public RoleMenuMapper roleMenuMapper;

    @Autowired
    public MenuService menuService;

    @Override
    public List<String> getRoleById(String id) {
        return roleMenuMapper.getRoleById(id);
    }

    @Override
    @Transactional
    public Boolean updataRoleByMenuId(String id, List<String> roles, Boolean batch) {

        // 判断是否批量操作
        if (batch) {
            // 获取子菜单id集合
            List<String> ids = menuService.getChildrenIds(id);
            this.deleteBatchMenuIds(ids.toArray());

            // 重新添加
            // 批量添加
            if (roles.size() == 0) return true;
            List<RoleMenu> roleMenus = new ArrayList<>();
            ids.forEach(menuId -> {
                roles.forEach(roleId -> {
                    roleMenus.add(new RoleMenu(roleId, menuId));
                });
            });

            return this.saveBatch(roleMenus);
        } else {
            // 清空以前的角色列表
            QueryWrapper<RoleMenu> remove = new QueryWrapper<>();
            remove.eq("menu_id", id);
            boolean b = this.remove(remove);

            // 添加现有角色列表
            List<RoleMenu> roleMenuList = new ArrayList<>();
            roles.forEach(role -> {
                roleMenuList.add(new RoleMenu(role, id));
            });
            return this.saveBatch(roleMenuList);
        }

    }

    @Override
    public List<String> getMenuIdByRoleId(String id) {
        return roleMenuMapper.getMenuIdByRoleId(id);
    }

    @Override
    @Transactional
    public Boolean updateByRoleId(String roleId, List<String> menus) {
        QueryWrapper<RoleMenu> removeWrapper = new QueryWrapper<>();
        removeWrapper.eq("role_id", roleId);
        roleMenuMapper.delete(removeWrapper);

        List<RoleMenu> roleMenuList = new ArrayList<>();
        menus.forEach(menuId -> {
            roleMenuList.add(new RoleMenu(roleId, menuId));
        });
        return this.saveBatch(roleMenuList);
    }

    @Override
    public int deleteBatchMenuIds(Object[] ids) {
        return roleMenuMapper.deleteBatchMenuIds(ids);
    }

    @Override
    public boolean deleteBatchRoleId(String id) {
        QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", id);

        return this.remove(queryWrapper);
    }
}
