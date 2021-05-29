package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.PubZone;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-23
 */
public interface PubZoneService extends IService<PubZone> {

    List<PubZone> getNodeByLevel(String s);

    List<PubZone> getChildByParentId(Integer parentId);

    Boolean isZoneIdValid(Integer integer);
}
