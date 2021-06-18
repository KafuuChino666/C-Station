package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.WorkFlow;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-06-02
 */
public interface WorkFlowService extends IService<WorkFlow> {

    IPage<WorkFlow> getVideoAuditWork(Integer page, Integer limit);

    Boolean removeVideoAuditWork(Integer id);

    boolean upDateWordUsableById(Integer id);

    boolean validateWorkFlowName(String workFlowName);
}
