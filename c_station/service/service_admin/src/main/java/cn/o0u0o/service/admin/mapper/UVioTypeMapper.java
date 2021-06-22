package cn.o0u0o.service.admin.mapper;

import cn.o0u0o.service.admin.entity.UVioType;
import cn.o0u0o.service.admin.entity.UViolation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Caleb Chen
 * @create 2021-06-22 8:45
 */
public interface UVioTypeMapper extends BaseMapper<UVioType> {

    UVioType selectDescribeByID(Integer vioTypeId);

}
