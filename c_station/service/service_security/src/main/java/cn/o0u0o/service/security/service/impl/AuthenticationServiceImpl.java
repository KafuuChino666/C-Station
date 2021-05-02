package cn.o0u0o.service.security.service.impl;

import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.entity.Staff;
import cn.o0u0o.service.security.mapper.MenuMapper;
import cn.o0u0o.service.security.service.AuthenticationService;
import cn.o0u0o.service.security.service.MenuService;
import cn.o0u0o.service.security.service.StaffService;
import cn.o0u0o.service.sms.service.SmsService;
import cn.o0u0o.service.sms.util.RandomUtils;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private StaffService staffService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean sendCaptcha(String username) {

        String mobile = staffService.getMobileByUsername(username);

        //生成验证码
        String checkCode = RandomUtils.getFourBitRandom();
        try {
            // 发送短信
            smsService.send(mobile, checkCode);
            //将验证码存入redis缓存
            redisTemplate.opsForValue().set(mobile, checkCode, 5, TimeUnit.MINUTES);
            return true;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}
