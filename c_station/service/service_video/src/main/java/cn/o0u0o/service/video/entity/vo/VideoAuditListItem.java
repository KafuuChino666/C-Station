package cn.o0u0o.service.video.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Guo Yangyang
 * @version 1.0
 * @date 2021/6/22 21:06
 */
@Data
public class VideoAuditListItem {

    private Integer id;
    private Date gmtModified;
    private String authorId;
    private String auditorId;
    private String videoTitle;
    private String zoneTitle;
    private String disciplineInfo;
    private String auditorInfo;
}
