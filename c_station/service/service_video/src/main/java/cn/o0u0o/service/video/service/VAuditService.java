package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.VAudit;
import cn.o0u0o.service.video.entity.vo.VideoAuditInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-26
 */
public interface VAuditService extends IService<VAudit> {

    VideoAuditInfo getVideoInfoByItemId(Integer itemId);

    Boolean auditPass(Integer itemId, String username);

    Boolean auditNotPass(Integer itemId, String username, String disciplineInfo);
}
