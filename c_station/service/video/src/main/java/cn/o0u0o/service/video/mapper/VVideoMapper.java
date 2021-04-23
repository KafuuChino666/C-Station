package cn.o0u0o.service.video.mapper;

import cn.o0u0o.service.video.entity.VVideo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-04-20
 */
public interface VVideoMapper extends BaseMapper<VVideo> {

    @Select("select count(video_id) from v_video")
    Integer getVideoCount();

    Integer getZoneCountByType(Integer type);

}
