package cn.o0u0o.service.admin.service;

import cn.o0u0o.service.admin.entity.UCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-26
 */
public interface UCategoryService extends IService<UCategory> {

    List<UCategory> selectAllCategory();

    Boolean removeUserCategoryByID(Integer id);

    Boolean unRemoveUserCategoryByID(Integer id);

    Integer queryCategoryByID(Integer id);
}
