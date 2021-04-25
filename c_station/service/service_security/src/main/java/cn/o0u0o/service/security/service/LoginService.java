package cn.o0u0o.service.security.service;

import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.entity.Resource;
import cn.o0u0o.service.security.entity.Role;
import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.mapper.RoleMenuMapper;
import cn.o0u0o.service.security.mapper.StaffMapper;
import cn.o0u0o.service.security.mapper.StaffRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    public StaffMapper staffMapper;

    @Autowired
    public StaffRoleService staffRoleService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.eq("username", name);
        System.out.println(name);

        Staff staff = staffMapper.selectOne(wrapper);
        if (staff == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        //获取到用户角色列表
        List<Role> roleIds = staffRoleService.selectByStaffId(staff.getId());

        List<GrantedAuthority> list = new ArrayList<>();

        //角色处理
        for (Role role : roleIds) {
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getName());
            list.add(grantedAuthority);
        }

        return new User(staff.getUsername(), staff.getPassword(), list);
    }
}
