package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.entity.Resource;
import cn.o0u0o.service.security.mapper.MenuMapper;
import cn.o0u0o.service.security.service.MenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    public MenuMapper menuMapper;

    @Override
    public boolean updateHiddenById(String id, Boolean status) {
        return menuMapper.updateHidden(id, status ? 1 : 0);
    }

    @Override
    public IPage<Menu> selectPage(Integer page, Integer limit) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("level"); //排序

        Page<Menu> pageParam = new Page<>(page, limit);
        return menuMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public List<Menu> getListExcludeOwn(String id) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("id", id);
        queryWrapper.select("id","title","level","name");

        List<Menu> menus = menuMapper.selectList(queryWrapper);
        return menus;
    }

    @Override
    public boolean add(Menu menu) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("level");
        queryWrapper.eq("id", menu.getParentId());
        Menu parentMenu = menuMapper.selectOne(queryWrapper);

        menu.setLevel(parentMenu.getLevel() + 1);
        boolean b = this.save(menu);
        return b;
    }

    @Override
    public List<Menu> getByName(String name) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);

        return menuMapper.selectList(queryWrapper);
    }

}
