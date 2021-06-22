package cn.o0u0o.service.admin.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Caleb Chen
 * @create 2021-06-22 18:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VioDes {
    // 创建时间（违规时间）
    private Date gmtCreate;
    // 违规描述
    private String vioDescribe;
    // 视频Id
    private Integer videoId;
    // 违规类型
    private String vioType;
}
