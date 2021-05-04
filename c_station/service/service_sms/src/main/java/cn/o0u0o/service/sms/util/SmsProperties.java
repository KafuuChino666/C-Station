package cn.o0u0o.service.sms.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = "classpath:app.yml")
@ConfigurationProperties(prefix = "aliyun.sms")
public class SmsProperties {

    @Value("${regionId}")
    private String regionId;

    @Value("${keyId}")
    private String keyId;

    @Value("${keySecret}")
    private String keySecret;

    @Value("${templateCode}")
    private String templateCode;

    @Value("${signName}")
    private String signName;
}
