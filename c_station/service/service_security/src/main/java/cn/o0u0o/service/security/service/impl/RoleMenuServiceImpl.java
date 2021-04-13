package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.RoleMenu;
import cn.o0u0o.service.security.mapper.RoleMenuMapper;
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

    @Override
    public List<String> getRoleById(String id) {
        return roleMenuMapper.getRoleById(id);
    }

    @Override
    @Transactional
    public Boolean updataRoleByMenuId(String id, List<String> roles) {
        // 清空以前的角色列表
        QueryWrapper<RoleMenu> remove = new QueryWrapper<>();
        remove.eq("menu_id", id);
        boolean b = this.remove(remove);

        // 添加现有角色列表
        List<RoleMenu> roleMenuList = new ArrayList<>();
        roles.forEach(role -> {
            roleMenuList.add(new RoleMenu(role, id));
        });
        boolean b1 = this.saveBatch(roleMenuList);
        return b1;
    }
}
