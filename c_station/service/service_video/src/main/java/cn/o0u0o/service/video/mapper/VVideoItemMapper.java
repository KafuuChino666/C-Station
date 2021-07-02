package cn.o0u0o.service.video.mapper;

import cn.o0u0o.service.video.entity.VVideoItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-26
 */
public interface VVideoItemMapper extends BaseMapper<VVideoItem> {

    String getLocationById(Integer videoItemId);
}
