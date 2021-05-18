package cn.o0u0o.service.video.mapper;

import cn.o0u0o.service.video.entity.VVideoInfo;
import cn.o0u0o.service.video.entity.VVideoStatus;
import cn.o0u0o.service.video.entity.vo.QueryForm;
import cn.o0u0o.service.video.entity.vo.TableData;
import cn.o0u0o.service.video.entity.vo.VideoInfoForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-17
 */
public interface VVideoInfoMapper extends BaseMapper<VVideoInfo> {
    IPage<TableData> selectVideoByTerm(Page<QueryForm> page, Integer videoId, String videoTitle, Integer authorId, Date startTime, Date endTime, String playNub, Integer videoStatus);

    VideoInfoForm getVideoInfoById(Integer id);

    @Select("SELECT id, video_status FROM v_video_status")
    List<VVideoStatus> selectAllVideoStatus();

}
