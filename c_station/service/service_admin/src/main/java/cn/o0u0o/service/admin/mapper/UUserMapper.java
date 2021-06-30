package cn.o0u0o.service.admin.mapper;

import cn.o0u0o.service.admin.entity.UCategory;
import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.entity.vo.EditUserData;
import cn.o0u0o.service.admin.entity.vo.Select;
import cn.o0u0o.service.admin.entity.vo.UserData;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Update;

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
    @org.apache.ibatis.annotations.Select("select user_name, category_id, gender_id from u_user where id = #{userId}")
    EditUserData selectEditUserDataByID(Integer userId);

    @Update("update u_user set user_name = #{userName}, category_id = #{categoryId}, gender_id = #{genderId} where id = #{userId}")
    Integer updateUserByID(String userName, Integer categoryId, Integer genderId, Integer userId);

}
