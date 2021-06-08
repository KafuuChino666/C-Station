package cn.o0u0o.service.security.mapper;

import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.entity.vo.MenuVo;
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
public interface MenuMapper extends BaseMapper<Menu> {

    Boolean updateHidden(String id, int hidden);

    List<MenuVo> selectHierarchyMenuByParentId(int parentId);

    Boolean updateParentHasChildren(String parentId);

    List<Menu> selectIdAndName();

    List<MenuVo> getHierarchyIdById(String id);
}
