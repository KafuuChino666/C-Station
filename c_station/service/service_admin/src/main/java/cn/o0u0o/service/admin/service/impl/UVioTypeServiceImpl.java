package cn.o0u0o.service.admin.service.impl;

import cn.o0u0o.service.admin.entity.UVioType;
import cn.o0u0o.service.admin.mapper.UVioTypeMapper;
import cn.o0u0o.service.admin.service.UVioTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Caleb Chen
 * @create 2021-06-22 10:01
 */
@Service
public class UVioTypeServiceImpl extends ServiceImpl<UVioTypeMapper, UVioType> implements UVioTypeService {

    @Autowired
    private UVioTypeMapper uVioTypeMapper;

}
