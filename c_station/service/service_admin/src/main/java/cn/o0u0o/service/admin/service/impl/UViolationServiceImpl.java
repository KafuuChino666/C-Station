package cn.o0u0o.service.admin.service.impl;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.admin.entity.UVioType;
import cn.o0u0o.service.admin.entity.UViolation;
import cn.o0u0o.service.admin.entity.vo.VioDes;
import cn.o0u0o.service.admin.mapper.UVioTypeMapper;
import cn.o0u0o.service.admin.mapper.UViolationMapper;
import cn.o0u0o.service.admin.service.UViolationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-06-22 8:46
 */
@Service
public class UViolationServiceImpl extends ServiceImpl<UViolationMapper, UViolation> implements UViolationService {

    @Autowired
    private UViolationMapper uViolationMapper;
    @Autowired
    private UVioTypeMapper uVioTypeMapper;

    /**
     * 根据userId查询用户违规记录
     *
     * @param userId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<VioDes> queryViolationById(Integer userId) {
        VioDes des = null;
        List<VioDes> vioDesList = new ArrayList<>();
        List<UViolation> uViolations = uViolationMapper.selectUserViolationByID(userId);
        for(UViolation uViolation : uViolations) {
            Integer vioTypeId = uViolation.getVioTypeId();
            if(vioTypeId != null && vioTypeId > 0) {
                UVioType uVioType = uVioTypeMapper.selectDescribeByID(vioTypeId);
                // 提取查询的数据
                Date gmtCreate = uViolation.getGmtCreate();
                String vioDescribe = uVioType.getVioDescribe();
                Integer vioVideoId = uViolation.getVioVideoId();
                String vioType = uVioType.getVioType();
                // 封装数据
                des = new VioDes(gmtCreate, vioDescribe, vioVideoId, vioType);
                vioDesList.add(des);
            }
        }
        return vioDesList;
    }
}
