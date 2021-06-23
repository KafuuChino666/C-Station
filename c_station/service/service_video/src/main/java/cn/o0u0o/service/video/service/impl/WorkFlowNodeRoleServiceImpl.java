package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.WorkFlowNodeRole;
import cn.o0u0o.service.video.mapper.WorkFlowNodeMapper;
import cn.o0u0o.service.video.mapper.WorkFlowNodeRoleMapper;
import cn.o0u0o.service.video.service.WorkFlowNodeRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-06-04
 */
@Service
public class WorkFlowNodeRoleServiceImpl extends ServiceImpl<WorkFlowNodeRoleMapper, WorkFlowNodeRole> implements WorkFlowNodeRoleService {

    @Autowired
    public WorkFlowNodeMapper workFlowNodeMapper;

    @Override
    public Integer getNodeIdByUserName(String username) {
        return workFlowNodeMapper.selectNodeIdByUserName(username);
    }
}
