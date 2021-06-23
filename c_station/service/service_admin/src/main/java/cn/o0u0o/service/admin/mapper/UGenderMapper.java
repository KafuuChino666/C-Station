package cn.o0u0o.service.admin.mapper;

import cn.o0u0o.service.admin.entity.UGender;
import cn.o0u0o.service.admin.entity.UUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-06-23 21:05
 */
public interface UGenderMapper extends BaseMapper<UGender> {

    @Select("select id, gender, gmt_Create, gmt_Modified from u_gender")
    List<UGender> selectAllGender();

}
