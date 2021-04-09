package cn.o0u0o.service.security.service;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.security.entity.Role;
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
public interface RoleService extends IService<Role> {

    List<Role> getAll();
}
