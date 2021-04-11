package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.Resource;
import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.mapper.ResourceMapper;
import cn.o0u0o.service.security.service.ResourceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Autowired
    public ResourceMapper resourceMapper;

    @Override
    public Boolean deleteById(String id) {
        return this.removeById(id);
    }

    @Override
    public Boolean update(Resource resource) {
        QueryWrapper<Resource> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", resource.getId());
        return this.update(resource, queryWrapper);
    }

    @Override
    public IPage<Resource> selectPage(Integer page, Integer limit) {
        QueryWrapper<Resource> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id"); //排序

        Page<Resource> pageParam = new Page<>(page, limit);
        return resourceMapper.selectPage(pageParam, queryWrapper);
    }

    @Override
    public List<Resource> getByIdAndName(String text) {
        QueryWrapper<Resource> queryWrapper = new QueryWrapper();

        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(text.trim()).matches()) {
            queryWrapper.eq("id", text.trim());
        } else {
            queryWrapper.like("name", text.trim());
        }
        List<Resource> resources = resourceMapper.selectList(queryWrapper);
        return resources;
    }
}
