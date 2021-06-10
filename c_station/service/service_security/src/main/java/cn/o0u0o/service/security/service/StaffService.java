package cn.o0u0o.service.security.service;

import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.entity.vo.StaffVo;
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
public interface StaffService extends IService<Staff> {
    Staff getById(Integer staffId);

    IPage<Staff> selectPage(Long page, Long limit);

    void updateStatusById(Integer id, Boolean status);

    String getMobileByUsername(String username);

    Boolean validateUserName(String username);

    boolean createStaff(StaffVo staff);

    List<Menu> getMenusByUserName(String userFromToken);
}
