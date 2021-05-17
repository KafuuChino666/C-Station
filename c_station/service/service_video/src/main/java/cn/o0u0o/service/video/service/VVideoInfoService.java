package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.VVideoInfo;
import cn.o0u0o.service.video.entity.vo.QueryForm;
import cn.o0u0o.service.video.entity.vo.TableData;
import cn.o0u0o.service.video.entity.vo.VideoInfoForm;
import cn.o0u0o.service.video.entity.vo.VideoInfoResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-04-20
 */

public interface VVideoInfoService extends IService<VVideoInfo> {

    IPage<TableData> selectVideoByTerm(Integer page, Integer limit, Integer videoId, String videoTitle, Integer authorId, Date startTime, Date endTime, String playNub, Integer videoStatus);

    VideoInfoResult getVideoInfoById(Integer videoId);

    List<VVideoInfo> selectAllVideoStatus();

}
