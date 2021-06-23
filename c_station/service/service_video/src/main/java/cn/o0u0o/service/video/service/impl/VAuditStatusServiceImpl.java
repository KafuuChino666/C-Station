package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VAuditStatus;
import cn.o0u0o.service.video.entity.vo.VideoAuditListItem;
import cn.o0u0o.service.video.mapper.VAuditStatusMapper;
import cn.o0u0o.service.video.service.VAuditStatusService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
public class VAuditStatusServiceImpl extends ServiceImpl<VAuditStatusMapper, VAuditStatus> implements VAuditStatusService {

    @Autowired
    public VAuditStatusMapper vAuditStatusMapper;

    @Override
    public boolean addAudit(Integer videoId) {
        // 查出当前视频流程号
        Integer flow_id = 1;

        // 查出的一个节点号
        Integer node_id = vAuditStatusMapper.selectFlowFirstNode(flow_id);

        return this.save(new VAuditStatus(videoId, flow_id, node_id, "#", "无", 0, "0"));
    }

    @Override
    public List<VideoAuditListItem> getListByNodeId(Integer nodeId) {
        return vAuditStatusMapper.selectListByNodeId(nodeId);
    }

    @Override
    public Boolean isUnfinished(String username) {
        return vAuditStatusMapper.selectUnfinishedByAuditor(username) != 0;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public Boolean lockAuditVideo(String username, Integer id) {
        return vAuditStatusMapper.lockAudit(username, id);
    }

    @Override
    public Integer getUnfinishedAudit(String username) {
        QueryWrapper<VAuditStatus> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("auditor", username);
        queryWrapper.select("id");
        VAuditStatus one = this.getOne(queryWrapper);
        if (one != null) {
            return Integer.valueOf(one.getId());
        }
        return 0;
    }
}
