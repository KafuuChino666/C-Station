package cn.o0u0o.service.security.mapper;

import cn.o0u0o.service.security.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    Boolean updateHidden(String id, int hidden);

    List<String> getRoleById(String id);

    List<String> getMenuIdByRoleId(String id);

    int deleteBatchMenuIds(Object[] ids);
}
