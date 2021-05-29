package cn.o0u0o.service.video.entity.vo;

import lombok.Data;

/**
 * @author Guo Yangyang
 * @version 1.0
 * @date 2021/5/28 20:45
 */
@Data
public class FileUploadComplete {
    private String Status;
    private String FileUrl;
    private String VideoId;
    private String EventType;
    private String EventTime;
    private Long Size;
}
