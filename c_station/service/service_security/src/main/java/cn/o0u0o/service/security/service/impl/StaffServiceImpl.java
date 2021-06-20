package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.entity.vo.StaffAuthInfo;
import cn.o0u0o.service.security.entity.vo.StaffVo;
import cn.o0u0o.service.security.mapper.StaffMapper;
import cn.o0u0o.service.security.service.MenuService;
import cn.o0u0o.service.security.service.StaffRoleService;
import cn.o0u0o.service.security.service.StaffService;
import cn.o0u0o.service.security.util.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    public MenuService menuService;

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

        // 密码加密到md5
        st.setPassword( MD5.encrypt(st.getPassword()));
        st.setIcon("#");

        // 添加员工
        int insert = staffMapper.insert(st);

        // 绑定角色
        staffRoleService.batchBindRole(st.getId(), staff.getRoles());
        return insert == 1;
    }

    @Override
    public List<Menu> getMenusByUserName(String username) {

        return menuService.getMenusByUserName(username);
    }

    @Override
    public Staff getByUserName(String username) {

        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.select("id", "username", "icon", "nick_name");

        return this.getOne(queryWrapper);
    }

    @Transactional
    @Override
    public Boolean removeStaffById(String staffId) {

        // 删除角色绑定信息
        staffRoleService.removeByStaffId(staffId);
        // 删除员工
        boolean b = this.removeById(staffId);
        return b;
    }

    @Override
    public StaffVo getEchoDataByStaffId(String staffId) {

        StaffVo staffVo = new StaffVo();
        // 获取员工基础信息
        Staff staff = this.getById(staffId);
        BeanUtils.copyProperties(staff, staffVo);
        staffVo.setPassword("系统默认过滤敏感字段");
        
        // 获取角色
        staffVo.setRoles(staffRoleService.getByStatusId(staffId));

        return staffVo;
    }

    @Override
    public StaffAuthInfo getAuthInfo(String username) {
        StaffAuthInfo authInfo = staffMapper.selectAuthInfo(username);
        if (authInfo.getMobile() != null) {
            authInfo.setMobile(authInfo.getMobile().replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
        }
        if (authInfo.getEmail() != null) {
            authInfo.setEmail(authInfo.getEmail().replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4"));
        }
        return authInfo;
    }

    @Override
    public boolean sendEmailAuthCode(String username) {

        QueryWrapper<Staff> staffQueryWrapper = new QueryWrapper<>();
        staffQueryWrapper.eq("username", username);
        staffQueryWrapper.select("email");

        Staff staff = staffMapper.selectOne(staffQueryWrapper);
        if (staff.getEmail().isEmpty()) {
            return false;
        }
        // 发送邮箱验证码

        return false;
    }

}
