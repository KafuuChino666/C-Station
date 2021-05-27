package cn.o0u0o.service.admin.service;

import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.entity.vo.Select;
import cn.o0u0o.service.admin.entity.vo.UserData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

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



}
