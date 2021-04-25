package cn.o0u0o.service.security.mapper;

import cn.o0u0o.service.security.entity.Resource;
import cn.o0u0o.service.security.entity.Role;
import cn.o0u0o.service.security.entity.StaffRole;
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
public interface StaffRoleMapper extends BaseMapper<StaffRole> {

    List<String> getByStatusId(String id);

    List<Role> getRoleByStatusId(String id);

    List<String> getResourceByStaffId(String id);
}
