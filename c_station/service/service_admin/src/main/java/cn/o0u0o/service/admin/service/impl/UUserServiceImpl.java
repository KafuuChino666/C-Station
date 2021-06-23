package cn.o0u0o.service.admin.service.impl;

import cn.o0u0o.service.admin.entity.UCategory;
import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.entity.vo.Select;
import cn.o0u0o.service.admin.entity.vo.UserData;
import cn.o0u0o.service.admin.mapper.UUserMapper;
import cn.o0u0o.service.admin.service.UUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询方法调用mapper
     * @param page
     * @param limit
     * @return
     */
    @Override
    public IPage<UserData> selectUserAll(Integer page, Integer limit) {
        Page<UserData> pageParam = new Page<>(page, limit);
        return uUserMapper.selectUserAll(pageParam);
    }

    /**
     * 查询方法调用mapper
     * @param page
     * @param limit
     * @param select
     * @return
     */
    @Override
    public IPage<UserData> selectUserBySelect(Integer page, Integer limit, Select select) {
        Page<Select> pageParam = new Page<>(page, limit);
        return uUserMapper.selectUserBySelect(pageParam, select.getSelectUserID(), select.getSelectType(), select.getSelectUserName());
    }

    /**
     * 根据条件查询用户数量
     * @return
     */
    @Override
    public Integer selectUserCount(Map<String, Integer> userType) {
        QueryWrapper<UUser> wrapper = new QueryWrapper<>();
        wrapper.allEq(userType, false);
        return uUserMapper.selectCount(wrapper);
    }

    /**
     * 查询所有性别信息
     * @return
     */
    @Override
    public List<UUser> selectAllGender() {
        List<UUser> uUsers = uUserMapper.selectAllGender();
        return uUsers;
    }
}
