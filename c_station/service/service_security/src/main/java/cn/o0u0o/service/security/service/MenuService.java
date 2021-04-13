package cn.o0u0o.service.security.service;

import cn.o0u0o.service.security.entity.Menu;
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
public interface MenuService extends IService<Menu> {

    boolean updateHiddenById(String id, Boolean status);

    IPage<Menu> selectPage(Integer page, Integer limit);

    List<Menu> getListExcludeOwn(String id);

    boolean add(Menu menu);

    List<Menu> getByName(String name);
}
