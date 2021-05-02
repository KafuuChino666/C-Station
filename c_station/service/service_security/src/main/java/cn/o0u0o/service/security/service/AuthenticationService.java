package cn.o0u0o.service.security.service;

import cn.o0u0o.service.security.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AuthenticationService {
    boolean sendCaptcha(String username);
}
