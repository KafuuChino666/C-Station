package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VVideoInfo;
import cn.o0u0o.service.video.entity.vo.QueryForm;
import cn.o0u0o.service.video.entity.vo.TableData;
import cn.o0u0o.service.video.mapper.VVideoInfoMapper;
import cn.o0u0o.service.video.service.VVideoInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public IPage<TableData> selectVideoByTerm(Integer page, Integer limit, Integer videoId, String videoTitle, Integer authorId, Date startTime, Date endTime, Long playNub, String videoStatus) {
        Page<QueryForm> pageParam = new Page<>(page, limit);
        return vVideoInfoMapper.selectVideoByTerm(pageParam, videoId, videoTitle, authorId, startTime, endTime, playNub, videoStatus);
    }
}
