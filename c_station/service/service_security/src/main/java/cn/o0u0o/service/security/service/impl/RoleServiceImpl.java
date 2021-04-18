package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.Role;
import cn.o0u0o.service.security.mapper.RoleMapper;
import cn.o0u0o.service.security.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
