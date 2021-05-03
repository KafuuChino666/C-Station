package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VVideoInfo;
import cn.o0u0o.service.video.entity.vo.QueryForm;
import cn.o0u0o.service.video.entity.vo.TableData;
import cn.o0u0o.service.video.mapper.VVideoInfoMapper;
import cn.o0u0o.service.video.service.VVideoInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-04-20
 */
@Service
public class VVideoInfoServiceImpl extends ServiceImpl<VVideoInfoMapper, VVideoInfo> implements VVideoInfoService {

    @Autowired
    private VVideoInfoMapper vVideoInfoMapper;


    @Override
    public TableData selectVideoByTerm(QueryForm queryForm) {
        Integer videoId = queryForm.getVideoId();
        String videoTitle = queryForm.getVideoTitle();
        Integer authorId = queryForm.getAuthorId();
        Date startTime = queryForm.getStartTime();
        Date endTime = queryForm.getEndTime();
        Long playNub = queryForm.getPlayNub();
        String videoStatus = queryForm.getVideoStatus();

        return vVideoInfoMapper.selectVideoByTerm(videoId, videoTitle, authorId, startTime, endTime, playNub, videoStatus);
    }
}
