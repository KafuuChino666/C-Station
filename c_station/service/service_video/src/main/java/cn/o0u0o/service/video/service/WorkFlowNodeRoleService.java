package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.WorkFlowNodeRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-06-04
 */
public interface WorkFlowNodeRoleService extends IService<WorkFlowNodeRole> {

    Integer getNodeIdByUserName(String username);
}
