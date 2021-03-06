package cn.o0u0o.service.admin.mapper;

import cn.o0u0o.service.admin.entity.UCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-26
 */
public interface UCategoryMapper extends BaseMapper<UCategory> {

    @Select("select id, category, gmt_Create, gmt_Modified from u_category")
    List<UCategory> selectAllCategory();

    Boolean deleteCategoryByID(Integer id);

    Boolean unDeleteCategoryByID(Integer id);

    @Select("select category_id from u_user where id = #{id}")
    Integer selectCategoryByID(Integer id);

    @Select("select category from u_category where id = #{id}")
    String selectCategoryByCategoryID(Integer id);

}
