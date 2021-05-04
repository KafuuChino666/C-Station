package cn.o0u0o.service.video.mapper;

import cn.o0u0o.service.video.entity.VVideoStatus;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-04-21 21:44
 */
public interface VVideoStatusMapper extends BaseMapper<VVideoStatus> {

    @Select("SELECT video_status FROM v_video_status")
    List<VVideoStatus> selectAllVideoStatus();

}
