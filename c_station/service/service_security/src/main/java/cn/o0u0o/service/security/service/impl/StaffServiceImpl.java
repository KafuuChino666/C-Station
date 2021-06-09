package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.entity.vo.StaffVo;
import cn.o0u0o.service.security.mapper.StaffMapper;
import cn.o0u0o.service.security.service.StaffRoleService;
import cn.o0u0o.service.security.service.StaffService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {

    @Autowired
    public StaffMapper staffMapper;

    @Autowired
    public StaffRoleService staffRoleService;

    @Override
    public Staff getById(Integer staffId) {
        return staffMapper.selectById(staffId);
    }

    @Override
    public IPage<Staff> selectPage(Long page, Long limit) {
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id"); //排序

        Page<Staff> pageParam = new Page<>(page, limit);
        return staffMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public void updateStatusById(Integer id, Boolean status) {
        staffMapper.updateStatus(id, status ? 1 : 0);
    }

    @Override
    public String getMobileByUsername(String username) {
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.select("mobile");
        Staff staff = staffMapper.selectOne(queryWrapper);
        return staff.getMobile();
    }

    @Override
    public Boolean validateUserName(String username) {
        int num = staffMapper.validateByUserName(username);
        return num == 0;
    }

    @Transactional
    @Override
    public boolean createStaff(StaffVo staff) {
        Staff st = new Staff();
        BeanUtils.copyProperties(staff, st);
        // 添加员工
        int insert = staffMapper.insert(st);

        // 绑定角色
        staffRoleService.batchBindRole(st.getId(), staff.getRoles());
        return insert == 1;
    }

}
