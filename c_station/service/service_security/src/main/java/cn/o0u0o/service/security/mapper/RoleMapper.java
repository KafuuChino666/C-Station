package cn.o0u0o.service.security.mapper;

import cn.o0u0o.service.security.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Options;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
public interface RoleMapper extends BaseMapper<Role> {

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int createRole(Role role);

    Boolean updateStatusById(String id, boolean status);
}
