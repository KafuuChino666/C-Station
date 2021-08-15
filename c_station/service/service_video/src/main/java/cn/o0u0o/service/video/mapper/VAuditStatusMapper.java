package cn.o0u0o.service.video.mapper;

import cn.o0u0o.service.video.entity.VAuditStatus;
import cn.o0u0o.service.video.entity.vo.VideoAuditInfo;
import cn.o0u0o.service.video.entity.vo.VideoAuditListItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-06-02
 */
public interface VAuditStatusMapper extends BaseMapper<VAuditStatus> {

    Integer selectFlowFirstNode(Integer flow_id);

    List<VideoAuditListItem> selectListByNodeId(Integer nodeId);

    int selectUnfinishedByAuditor(String username);

    Boolean lockAudit(String username, Integer id);

    VideoAuditInfo VideoInfoByItemId(Integer itemId);

    boolean auditPassAndMobileNode(Integer itemId, String username, Integer nextNodeId);

    boolean notPassUpdateStart(Integer itemId, String username, String disciplineInfo);
}
