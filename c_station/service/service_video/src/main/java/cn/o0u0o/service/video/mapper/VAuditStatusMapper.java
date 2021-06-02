package cn.o0u0o.service.video.mapper;

import cn.o0u0o.service.video.entity.VAuditStatus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-06-02
 */
public interface VAuditStatusMapper extends BaseMapper<VAuditStatus> {

    Integer selectFlowFirstNode(Long flow_id);
}
