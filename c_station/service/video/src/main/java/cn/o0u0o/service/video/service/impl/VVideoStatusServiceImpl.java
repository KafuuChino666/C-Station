package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VVideoStatus;
import cn.o0u0o.service.video.mapper.VVideoStatusMapper;
import cn.o0u0o.service.video.service.VVideoStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-04-21 21:46
 */
@Service
public class VVideoStatusServiceImpl extends ServiceImpl<VVideoStatusMapper, VVideoStatus> implements VVideoStatusService {

    private VVideoStatusMapper vVideoStatusMapper;

    @Override
    public List<VVideoStatus> selectAllVideoStatus() {

        List<VVideoStatus> statusList = vVideoStatusMapper.selectAllVideoStatus();
        return statusList;
    }
}
