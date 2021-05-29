package cn.o0u0o.service.video.mapper;

import cn.o0u0o.service.video.entity.VVideo;
import cn.o0u0o.service.video.entity.VVideoStatus;
import cn.o0u0o.service.video.entity.vo.QueryForm;
import cn.o0u0o.service.video.entity.vo.TableData;
import cn.o0u0o.service.video.entity.vo.VideoInfoForm;
import cn.o0u0o.service.video.entity.vo.VideoUpload;
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
 * @author Guo Yangyang
 * @since 2021-05-26
 */
public interface VVideoMapper extends BaseMapper<VVideo> {
    IPage<TableData> selectVideoByTerm(Page<QueryForm> page, Integer videoId, String videoTitle, Integer authorId, Date startTime, Date endTime, String playNub, Integer videoStatus);

    VideoInfoForm getVideoInfoById(Integer id);

    @Select("SELECT id, video_status FROM v_video_status")
    List<VVideoStatus> selectAllVideoStatus();

    long insertOneVideo(String author_id, Integer zone_id, String img_Url, String video_title, String video_brief, int video_status);
}
