package cn.o0u0o.service.admin.mapper;

import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.entity.vo.Select;
import cn.o0u0o.service.admin.entity.vo.UserData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-23
 */
public interface UUserMapper extends BaseMapper<UUser> {

    IPage<UserData> selectUserAll(Page<UserData> page);

    IPage<UserData> selectUserBySelect(Page<Select> page, Integer selectUserID, Integer selectType, String selectUserName);

}
