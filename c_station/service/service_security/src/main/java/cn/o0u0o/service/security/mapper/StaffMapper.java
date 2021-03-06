package cn.o0u0o.service.security.mapper;

import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.entity.vo.StaffAuthInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
public interface StaffMapper extends BaseMapper<Staff> {
    void updateStatus(Integer id, Integer status);

    int validateByUserName(String username);

    StaffAuthInfo selectAuthInfo(String username);
}
