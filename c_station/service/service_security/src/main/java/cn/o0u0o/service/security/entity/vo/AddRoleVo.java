package cn.o0u0o.service.security.entity.vo;

import cn.o0u0o.service.security.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class AddRoleVo {
    // 角色信息
    private Role roleInfo;

    // 菜单列表
    private List<String> menuList;

    // 资源列表
    private List<String> resourceList;
}
