package cn.o0u0o.service.admin.service.impl;

import cn.o0u0o.service.admin.entity.UCategory;
import cn.o0u0o.service.admin.mapper.UCategoryMapper;
import cn.o0u0o.service.admin.service.UCategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * @since 2021-05-26
 */
@Service
public class UCategoryServiceImpl extends ServiceImpl<UCategoryMapper, UCategory> implements UCategoryService {

    @Autowired
    private UCategoryMapper uCategoryMapper;

    @Override
    public List<UCategory> selectAllCategory() {
        List<UCategory> uCategories = uCategoryMapper.selectAllCategory();
        return uCategories;
    }


    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Override
    public Boolean removeUserCategoryByID(Integer id) {
        if(id != null && id > 0) {
            uCategoryMapper.deleteCategoryByID(id);
            return true;
        }
        return false;
    }

    /**
     * 根据id解除删除用户
     * @param id
     * @return
     */
    @Override
    public Boolean unRemoveUserCategoryByID(Integer id) {
        if(id != null && id > 0) {
            uCategoryMapper.unDeleteCategoryByID(id);
            return true;
        }
        return false;
    }
}
