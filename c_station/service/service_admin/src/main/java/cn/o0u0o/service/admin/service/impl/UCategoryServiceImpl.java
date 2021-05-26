package cn.o0u0o.service.admin.service.impl;

import cn.o0u0o.service.admin.entity.UCategory;
import cn.o0u0o.service.admin.mapper.UCategoryMapper;
import cn.o0u0o.service.admin.service.UCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
