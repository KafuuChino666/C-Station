package cn.o0u0o.service.security.service;

import cn.o0u0o.service.security.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
