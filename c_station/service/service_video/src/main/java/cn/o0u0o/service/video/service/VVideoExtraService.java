package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.VVideoExtra;
import cn.o0u0o.service.video.entity.vo.VideoUpload;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-26
 */
public interface VVideoExtraService extends IService<VVideoExtra> {

    boolean addVideo(Integer videoId, VideoUpload video);
}
