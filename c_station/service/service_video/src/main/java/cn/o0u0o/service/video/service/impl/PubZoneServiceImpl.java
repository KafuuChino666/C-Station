package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.PubZone;
import cn.o0u0o.service.video.mapper.PubZoneMapper;
import cn.o0u0o.service.video.service.PubZoneService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-23
 */
@Service
public class PubZoneServiceImpl extends ServiceImpl<PubZoneMapper, PubZone> implements PubZoneService {

    @Autowired
    public PubZoneMapper pubZoneMapper;

    @Override
    public List<PubZone> getNodeByLevel(String s) {

        // redis 缓存

        List<PubZone> pubZones = pubZoneMapper.selectNodeByLevel(s);


        return pubZones;
    }

    @Override
    public List<PubZone> getChildByParentId(Integer parentId) {

        List<PubZone> pubZones = pubZoneMapper.selectChildByParentId(parentId);
        return pubZones;
    }

    @Override
    public Boolean isZoneIdValid(Integer integer) {
        return pubZoneMapper.selectCountById(integer) == 1;
    }
}
