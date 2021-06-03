package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VVideoExtra;
import cn.o0u0o.service.video.entity.vo.VideoUpload;
import cn.o0u0o.service.video.mapper.VVideoExtraMapper;
import cn.o0u0o.service.video.service.VVideoExtraService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class VVideoExtraServiceImpl extends ServiceImpl<VVideoExtraMapper, VVideoExtra> implements VVideoExtraService {

    @Override
    public boolean addVideo(Integer videoId, VideoUpload video) {
        boolean b = this.save(new VVideoExtra(videoId, video.getTags(), video.getIsInnovate(),
                video.getIsWatermark(), video.getVideoCaption(), video.getIsCommerce(), video.getRestsCastCaption(),
                video.getFanDynamic(), video.getIsTiming(), video.getTimingTime()));
        return b;
    }
}
