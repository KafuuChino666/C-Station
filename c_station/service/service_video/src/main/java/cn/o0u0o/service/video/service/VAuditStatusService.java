package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.VAuditStatus;
import cn.o0u0o.service.video.entity.vo.VideoAuditListItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-06-02
 */
public interface VAuditStatusService extends IService<VAuditStatus> {

    boolean addAudit(Integer videoId);

    List<VideoAuditListItem> getListByNodeId(Integer nodeId);

    Boolean isUnfinished(String username);

    Boolean lockAuditVideo(String username, Integer id);

    Integer getUnfinishedAudit(String username);
}
