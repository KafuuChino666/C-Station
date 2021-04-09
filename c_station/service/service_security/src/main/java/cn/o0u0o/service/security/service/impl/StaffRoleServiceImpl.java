package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.security.entity.Role;
import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.entity.StaffRole;
import cn.o0u0o.service.security.mapper.StaffMapper;
import cn.o0u0o.service.security.mapper.StaffRoleMapper;
import cn.o0u0o.service.security.service.StaffRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.jdbc.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
@Service
public class StaffRoleServiceImpl extends ServiceImpl<StaffRoleMapper, StaffRole> implements StaffRoleService {

    @Autowired
    public StaffRoleMapper staffRoleMapper;

    @Override
    public List<String> getByStatusId(Integer id) {
        return staffRoleMapper.getByStatusId(id);
    }

    @Override
    @Transactional // 开启事务
    public Integer updateRolesById(Integer id, List<Integer> roles) {

        // 清空此用户角色
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("staff_id", id);
        boolean b = this.remove(queryWrapper);
        // 添加角色
        Collection<StaffRole> staffRoles = new ArrayList<>();
        roles.forEach(role -> {
            staffRoles.add(new StaffRole(Long.valueOf(id), Long.valueOf(role)));
        });
        boolean saveBatch = this.saveBatch(staffRoles);

        if (b && saveBatch) {
            return 1;
        }
        return 0;
    }
}
