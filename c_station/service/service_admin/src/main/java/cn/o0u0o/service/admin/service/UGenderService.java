package cn.o0u0o.service.admin.service;

import cn.o0u0o.service.admin.entity.UGender;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-06-23 21:05
 */
public interface UGenderService extends IService<UGender> {

    List<UGender> selectAllGender();

    String selectGenderByGenderID(Integer id);

    Integer selectGenderIDByID(Integer id);

}
