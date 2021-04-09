package cn.o0u0o.service.security.service;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.security.entity.Role;
import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.entity.StaffRole;
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
public interface StaffRoleService extends IService<StaffRole> {

    List<String> getByStatusId(Integer id);

    Integer updateRolesById(Integer id, List<Integer> roles);
}
