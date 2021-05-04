package cn.o0u0o.service.video.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Vod Properties
 */
@Data
@Component
@ConfigurationProperties(prefix="aliyun.vod")
public class VodProperties {
    private String keyid;
    private String keysecret;
    private String templateGroupId;
    private String workflowId;
}

