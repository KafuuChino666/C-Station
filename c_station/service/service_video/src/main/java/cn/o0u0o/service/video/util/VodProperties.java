package cn.o0u0o.service.video.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Vod Properties
 */
@Data
@Component
@PropertySource(value = "classpath:app.yml")
@ConfigurationProperties(prefix="aliyun.vod")
public class VodProperties {

    @Value("${keyid}")
    private String keyid;

    @Value("${keysecret}")
    private String keysecret;

    @Value("${templateGroupId}")
    private String templateGroupId;

    @Value("${workflowId}")
    private String workflowId;
}

