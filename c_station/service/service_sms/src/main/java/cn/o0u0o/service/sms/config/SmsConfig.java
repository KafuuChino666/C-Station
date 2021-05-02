package cn.o0u0o.service.sms.config;

import cn.o0u0o.service.sms.util.DxProperties;
import com.dingxianginc.ctu.client.CaptchaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsConfig {

    @Autowired
    private DxProperties dxProperties;

    @Bean
    public CaptchaClient captchaClient() {
        return new CaptchaClient(dxProperties.getAppId(),dxProperties.getAppSecret());
    }
}
