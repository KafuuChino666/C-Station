package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.VVideoItem;
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
public interface VVideoItemService extends IService<VVideoItem> {

    boolean addVideo(Integer videoId, Long size, VideoUpload video);

    String getLocationById(Integer videoId);
}
