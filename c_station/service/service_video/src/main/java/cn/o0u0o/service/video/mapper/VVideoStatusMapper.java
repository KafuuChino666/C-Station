package cn.o0u0o.service.video.mapper;

import cn.o0u0o.service.video.entity.VVideoStatus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-26
 */
public interface VVideoStatusMapper extends BaseMapper<VVideoStatus> {

    Integer getLineNumByFlowId(Integer id);

    Integer updateUsableById(Integer usable, Integer id);

    void updateUsable();

    Integer selectByWorkFlowName(String workFlowName);
}
