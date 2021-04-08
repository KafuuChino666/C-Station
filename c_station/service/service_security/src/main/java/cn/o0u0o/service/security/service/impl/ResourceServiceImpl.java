package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.Resource;
import cn.o0u0o.service.security.mapper.ResourceMapper;
import cn.o0u0o.service.security.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
