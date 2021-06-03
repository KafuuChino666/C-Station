package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.VAuditStatus;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
