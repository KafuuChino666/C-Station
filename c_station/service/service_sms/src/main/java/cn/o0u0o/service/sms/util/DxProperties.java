package cn.o0u0o.service.sms.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "dingxiang.sms")
public class DxProperties {
    private String appId;
    private String appSecret;
}
