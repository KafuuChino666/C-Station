package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VVideoItem;
import cn.o0u0o.service.video.entity.vo.VideoUpload;
import cn.o0u0o.service.video.mapper.VVideoItemMapper;
import cn.o0u0o.service.video.service.VVideoItemService;
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
    public boolean addVideo(Long videoId, Long size, VideoUpload video) {
        return this.save(new VVideoItem(videoId, 1, video.getVideoTitle(), size.toString(), video.getVideoId(), 0, 0));
    }
}
