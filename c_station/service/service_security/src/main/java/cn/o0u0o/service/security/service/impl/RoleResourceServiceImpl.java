package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.RoleResource;
import cn.o0u0o.service.security.mapper.RoleResourceMapper;
import cn.o0u0o.service.security.service.RoleResourceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResource> implements RoleResourceService {

    @Autowired
    public RoleResourceMapper roleResourceMapper;

    @Override
    public Boolean updateByRoleId(String roleId, List<String> resource) {
        List<RoleResource> roleResources = new ArrayList<>();
        resource.forEach(res -> {
            roleResources.add(new RoleResource(roleId, res));
        });
        return this.saveBatch(roleResources);
    }

    @Override
    public List<String> getResourceIdByRoleId(String roleId) {
        return roleResourceMapper.getResourceIdByRoleId(roleId);
    }
}
