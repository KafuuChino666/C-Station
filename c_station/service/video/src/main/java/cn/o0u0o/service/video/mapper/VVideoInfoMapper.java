package cn.o0u0o.service.video.mapper;

import cn.o0u0o.service.video.entity.VVideoInfo;
import cn.o0u0o.service.video.entity.vo.QueryForm;
import cn.o0u0o.service.video.entity.vo.TableData;
import cn.o0u0o.service.video.entity.vo.VideoInfoForm;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Date;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-04-20
 */
public interface VVideoInfoMapper extends BaseMapper<VVideoInfo> {

    IPage<TableData> selectVideoByTerm(Page<QueryForm> page, Integer videoId, String videoTitle, Integer authorId, Date startTime, Date endTime, Long playNub, String videoStatus);

    VideoInfoForm getVideoInfoById(Integer videoId);

}
