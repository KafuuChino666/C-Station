package cn.o0u0o.service.admin.mapper;

import cn.o0u0o.service.admin.entity.UCategory;
import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.entity.vo.EditUserData;
import cn.o0u0o.service.admin.entity.vo.Select;
import cn.o0u0o.service.admin.entity.vo.UserData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-23
 */
public interface UUserMapper extends BaseMapper<UUser> {

    /**
     * 查询所有用户
     * @param page 页码
     * @return
     */
    IPage<UserData> selectUserAll(Page<UserData> page);

    /**
     * 按此条件查询用户
     * @param page 页码
     * @param selectUserID 要查询的用户id
     * @param selectType 要查询的用户类型（会员）
     * @param selectUserName 要查询的用户昵称
     * @return
     */
    IPage<UserData> selectUserBySelect(Page<Select> page, Integer selectUserID, Integer selectType, String selectUserName);

    /**
     * 按照用户ID查询editData数据
     * @param userId
     * @return
     */
    @org.apache.ibatis.annotations.Select("select user_name, category_id category, gender_id gender from u_user where id = #{userId}")
    EditUserData selectEditUserDataByID(Integer userId);

}
