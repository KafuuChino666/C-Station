package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VAudit;
import cn.o0u0o.service.video.entity.vo.VideoAuditInfo;
import cn.o0u0o.service.video.mapper.VAuditMapper;
import cn.o0u0o.service.video.mapper.VAuditStatusMapper;
import cn.o0u0o.service.video.service.VAuditService;
import cn.o0u0o.service.video.service.WorkFlowNodeRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-26
 */
@Service
public class VAuditServiceImpl extends ServiceImpl<VAuditMapper, VAudit> implements VAuditService {

    @Autowired
    private VAuditStatusMapper vAuditStatusMapper;

    @Autowired
    private WorkFlowNodeRoleService workFlowNodeRoleService;

    @Override
    public VideoAuditInfo getVideoInfoByItemId(Integer itemId) {
        return vAuditStatusMapper.VideoInfoByItemId(itemId);
    }

    @Override
    public Boolean auditPass(Integer itemId, String username) {

        // 查询下一个节点
        Integer nextNodeId = workFlowNodeRoleService.getNextNodeIdByUserName(username);

        // 如果等于-1说明现在已经处于最后一个节点
        if (nextNodeId == -1) {
            // 视频发布，全部审核通过
            return true;
        }

        // 如果不是最后一个节点，则将此视频移到下一个节点当中

        // 移动视频节点，并将此审核员添加信息当中
        boolean b =vAuditStatusMapper.auditPassAndMobileNode(itemId, username, nextNodeId);
        // 确认
        return b;
    }

    @Override
    public Boolean auditNotPass(Integer itemId, String username, String disciplineInfo) {

        return vAuditStatusMapper.notPassUpdateStart(itemId, username, disciplineInfo);
    }
}
