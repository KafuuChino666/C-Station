package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.WorkFlowNode;
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
public interface WorkFlowNodeService extends IService<WorkFlowNode> {

    List<WorkFlowNode> getNodesByFlowId(Integer id);
}
