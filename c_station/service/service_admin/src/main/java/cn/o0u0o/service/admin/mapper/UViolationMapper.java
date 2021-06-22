package cn.o0u0o.service.admin.mapper;

import cn.o0u0o.service.admin.entity.UViolation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Caleb Chen
 * @create 2021-06-22 8:45
 */
public interface UViolationMapper extends BaseMapper<UViolation> {

    /**
     * 根据用户id查询违规信息
     * @param id
     * @return
     */
    UViolation selectUserViolationByID(Integer id);
}
