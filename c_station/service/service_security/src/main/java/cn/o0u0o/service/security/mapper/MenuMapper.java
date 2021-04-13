package cn.o0u0o.service.security.mapper;

import cn.o0u0o.service.security.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
public interface MenuMapper extends BaseMapper<Menu> {

    Boolean updateHidden(String id, int hidden);

}
