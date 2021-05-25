package cn.o0u0o.service.admin.service.impl;

import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.entity.vo.Select;
import cn.o0u0o.service.admin.entity.vo.UserData;
import cn.o0u0o.service.admin.mapper.UUserMapper;
import cn.o0u0o.service.admin.service.UUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-23
 */
@Service
public class UUserServiceImpl extends ServiceImpl<UUserMapper, UUser> implements UUserService {

    @Autowired
    private UUserMapper uUserMapper;

    @Override
    public IPage<UserData> selectUserAll(Integer page, Integer limit) {
        Page<UserData> pageParam = new Page<>(page, limit);
        return uUserMapper.selectUserAll(pageParam);
    }

    @Override
    public IPage<UserData> selectUserBySelect(Integer page, Integer limit, Integer selectUserID, Integer selectType, String selectUserName) {
        Page<Select> pageParam = new Page<>(page, limit);

        return uUserMapper.selectUserBySelect(pageParam, selectUserID, selectType, selectUserName);
    }
}
