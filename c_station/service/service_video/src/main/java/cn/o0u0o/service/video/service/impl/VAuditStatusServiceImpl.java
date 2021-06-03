package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VAuditStatus;
import cn.o0u0o.service.video.mapper.VAuditStatusMapper;
import cn.o0u0o.service.video.service.VAuditStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-06-02
 */
@Service
public class VAuditStatusServiceImpl extends ServiceImpl<VAuditStatusMapper, VAuditStatus> implements VAuditStatusService {

    @Autowired
    public VAuditStatusMapper vAuditStatusMapper;

    @Override
    public boolean addAudit(Integer videoId) {
        // 查出当前视频流程号
        Integer flow_id = 1;

        // 查出的一个节点号
        Integer node_id = vAuditStatusMapper.selectFlowFirstNode(flow_id);

        return this.save(new VAuditStatus(videoId, flow_id, node_id, 0, "无", 0, "0"));
    }
}
