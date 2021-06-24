package cn.o0u0o.service.admin.service.impl;

import cn.o0u0o.service.admin.entity.UGender;
import cn.o0u0o.service.admin.entity.UIntegral;
import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.mapper.UGenderMapper;
import cn.o0u0o.service.admin.mapper.UIntegralMapper;
import cn.o0u0o.service.admin.service.UGenderService;
import cn.o0u0o.service.admin.service.UIntegralService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-06-23 21:06
 */
@Service
public class UGenderServiceImpl extends ServiceImpl<UGenderMapper, UGender> implements UGenderService {

    @Autowired
    private UGenderMapper uGenderMapper;

    @Override
    public List<UGender> selectAllGender() {
        List<UGender> uGenders = uGenderMapper.selectAllGender();
        return uGenders;
    }
}
