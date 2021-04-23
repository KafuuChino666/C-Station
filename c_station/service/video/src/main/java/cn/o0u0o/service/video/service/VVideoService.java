package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.VVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-04-20
 */
public interface VVideoService extends IService<VVideo> {

    Integer getVideoCount();

    Integer getZoneCountByType(Integer type);
}
