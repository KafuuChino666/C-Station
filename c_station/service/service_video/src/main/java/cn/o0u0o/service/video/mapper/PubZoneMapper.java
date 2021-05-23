package cn.o0u0o.service.video.mapper;

import cn.o0u0o.service.video.entity.PubZone;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-23
 */
public interface PubZoneMapper extends BaseMapper<PubZone> {

    List<PubZone> selectNodeByLevel(String s);

    List<PubZone> selectChildByParentId(Integer parentId);
}
