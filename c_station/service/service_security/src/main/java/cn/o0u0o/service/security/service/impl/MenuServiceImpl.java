package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.entity.Resource;
import cn.o0u0o.service.security.entity.vo.MenuVo;
import cn.o0u0o.service.security.mapper.MenuMapper;
import cn.o0u0o.service.security.service.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;
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
        queryWrapper.eq("parent_id", 0);
        queryWrapper.eq("is_deleted", 1);
        queryWrapper.orderByAsc("sort"); //排序

        Page<Menu> pageParam = new Page<>(page, limit);
        return menuMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public List<Menu> getListExcludeOwn(String id) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("id", id);
//        queryWrapper.select("id","title","level","name");
        queryWrapper.select("id","name");

        List<Menu> menus = menuMapper.selectList(queryWrapper);
        return menus;
    }

    @Override
    public boolean add(Menu menu) {

        // 没有父类id默认为0
        if(menu.getParentId() == null) {
            menu.setParentId("0");
        } else {
            // 有父类id
            menuMapper.updateParentHasChildren(menu.getParentId());
        }
        boolean b = this.save(menu);
        return b;
    }

    @Override
    public List<Menu> getByName(String name) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);

        return menuMapper.selectList(queryWrapper);
    }

    @Override
    public List<MenuVo> getHierarchyMenu() {
        return menuMapper.selectHierarchyMenuByParentId(0);
    }

    @Override
    public List<Menu> getMenuByParentId(String id) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", id);
        return menuMapper.selectList(queryWrapper);
    }

    @Override
    public boolean deleted(String id) {
        List<String> ids = new ArrayList<>();
        List<MenuVo> menuVos = this.getHierarchyIdById(id);
        recursionReturnId(menuVos, ids);

        int i = baseMapper.deleteBatchIds(ids);

        return i > 0;
    }

    private List<String> recursionReturnId(List<MenuVo> menuVos, List<String> ids) {
        menuVos.forEach(item -> {
            ids.add(item.getId());
            if (item.getChildren() != null) {
                recursionReturnId(item.getChildren(), ids);
            }
        });
        return ids;
    }

    @Override
    public List<Menu> getIdAndName() {
        return menuMapper.selectIdAndName();
    }

    @Override
    public List<MenuVo> getHierarchyIdById(String id) {
        return menuMapper.getHierarchyIdById(id);
    }

}
