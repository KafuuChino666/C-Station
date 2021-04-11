package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.mapper.MenuMapper;
import cn.o0u0o.service.security.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Boolean b = menuMapper.updateHidden(id, status ? 1 : 0);
        return b;
    }

}
