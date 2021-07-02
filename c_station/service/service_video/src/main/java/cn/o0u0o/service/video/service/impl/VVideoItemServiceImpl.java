package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VVideoItem;
import cn.o0u0o.service.video.entity.vo.VideoUpload;
import cn.o0u0o.service.video.mapper.VVideoItemMapper;
import cn.o0u0o.service.video.service.VVideoItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-26
 */
@Service
public class VVideoItemServiceImpl extends ServiceImpl<VVideoItemMapper, VVideoItem> implements VVideoItemService {

    @Autowired
    private VVideoItemMapper vVideoItemMapper;

    @Override
    public Integer addVideo(Integer videoId, Long size, VideoUpload video) {
        VVideoItem item = new VVideoItem(videoId, 1, video.getVideoTitle(), size.toString(), video.getVideoId(), 0, 0);
        boolean b = this.save(item);
        if (b) {
            return Integer.valueOf(item.getId());
        }
        return 0;
    }

    @Override
    public String getLocationById(Integer videoItemId) {
        return vVideoItemMapper.getLocationById(videoItemId);
    }
}
