package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VVideo;
import cn.o0u0o.service.video.mapper.VVideoMapper;
import cn.o0u0o.service.video.service.VVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-04-20
 */
@Service
public class VVideoServiceImpl extends ServiceImpl<VVideoMapper, VVideo> implements VVideoService {

    @Autowired
    public VVideoMapper vVideoMapper;

    @Override
    public Integer getVideoCount() {
        Integer videoCount = vVideoMapper.getVideoCount();
        return videoCount;
    }

    @Override
    public Integer getZoneCountByType(Integer type) {
        Integer zoneCountByType = vVideoMapper.getZoneCountByType(type);

        return zoneCountByType;
    }

    @Override
    public String getVideoSource(String videoId) {
        QueryWrapper<VVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("video_location");
        queryWrapper.eq("video_id", videoId);

        VVideo video = vVideoMapper.selectOne(queryWrapper);

        return video.getVideoLocation();
    }
}
