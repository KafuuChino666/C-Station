package cn.o0u0o.service.security.service;

import cn.o0u0o.service.security.entity.Resource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
public interface ResourceService extends IService<Resource> {

    Boolean deleteById(String id);

    Boolean update(Resource resource);

    IPage<Resource> selectPage(Integer page, Integer limit);

    List<Resource> getByIdAndName(String text);
}
