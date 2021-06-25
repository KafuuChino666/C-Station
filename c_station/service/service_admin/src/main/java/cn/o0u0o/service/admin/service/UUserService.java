package cn.o0u0o.service.admin.service;

import cn.o0u0o.service.admin.entity.UCategory;
import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.entity.vo.EditUserData;
import cn.o0u0o.service.admin.entity.vo.Select;
import cn.o0u0o.service.admin.entity.vo.UserData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-23
 */
public interface UUserService extends IService<UUser> {

    IPage<UserData> selectUserAll(Integer page, Integer limit);

    IPage<UserData> selectUserBySelect(Integer page, Integer limit, Select select);

    Integer selectUserCount(Map<String, Integer> userType);

    EditUserData queryUserDataByID(Integer userId);
}
