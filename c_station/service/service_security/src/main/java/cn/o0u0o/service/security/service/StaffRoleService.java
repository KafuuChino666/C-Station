package cn.o0u0o.service.security.service;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.security.entity.*;
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

    List<String> getByStatusId(String id);

    Integer updateRolesById(String id, List<String> roles);

    List<Role> selectByStaffId(String id);

    List<String> selectResourceByStaffId(String id);
}
