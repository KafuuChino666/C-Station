package cn.o0u0o.service.video.entity.vo;

import lombok.Data;

import java.sql.Date;

/**
 * @author Guo Yangyang
 * @version 1.0
 * @date 2021/7/5 14:23
 */
@Data
public class VideoAuditInfo {
    private Integer videoId;
    private String videoTitle;
    private String videoBrief;
    private Date gmtModified;
    private String disciplineInfo;
    private String auditStatus;
    private Date auditTime;
    private String auditorInfo;
    private String userName;
}
