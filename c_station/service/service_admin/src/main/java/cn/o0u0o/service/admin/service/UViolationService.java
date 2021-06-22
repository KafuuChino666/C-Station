package cn.o0u0o.service.admin.service;

import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.entity.UViolation;
import cn.o0u0o.service.admin.entity.vo.VioDes;
import cn.o0u0o.service.admin.mapper.UUserMapper;
import cn.o0u0o.service.admin.mapper.UViolationMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-06-22 8:46
 */
public interface UViolationService extends IService<UViolation> {

    List<VioDes> queryViolationById(Integer userId);

}
