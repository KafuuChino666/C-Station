package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.WorkFlowNode;
import cn.o0u0o.service.video.mapper.WorkFlowNodeMapper;
import cn.o0u0o.service.video.service.WorkFlowNodeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-06-02
 */
@Service
public class WorkFlowNodeServiceImpl extends ServiceImpl<WorkFlowNodeMapper, WorkFlowNode> implements WorkFlowNodeService {

    @Override
    public List<WorkFlowNode> getNodesByFlowId(Integer id) {
        QueryWrapper<WorkFlowNode> nodeQueryWrapper = new QueryWrapper<>();
        nodeQueryWrapper.eq("flow_id", id);
        return this.list(nodeQueryWrapper);
    }
}
