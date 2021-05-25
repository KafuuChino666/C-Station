package cn.o0u0o.service.video.entity.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * 视频投稿相关字段
 */
@Data
public class VideoUpload {

    @NotEmpty(message = "非法请求")
    private String videoId;
    private Boolean isInnovate;
    private String videoTitle;
    private Integer[] zoneId;
    private String tags;
    private String videoBrief;
    private Boolean isDeclare;
    private Boolean isWatermark;
    private String videoCaption;
    private Boolean isCommerce;
    private Boolean restsCastCaption;
    private String fanDynamic;
    private Boolean isTiming;
    private Date timingTime;

//    public Integer getInnovate() {
//        return isInnovate ? 1 : 0;
//    }
//
//    public Integer getDeclare() {
//        return isDeclare ? 1 : 0;
//    }
//
//    public Integer getWatermark() {
//        return isWatermark ? 1 : 0;
//    }
//
//    public Integer getCommerce() {
//        return isCommerce ? 1 : 0;
//    }
//
//    public Integer getRestsCastCaption() {
//        return restsCastCaption ? 1 : 0;
//    }
//
//    public Integer getTiming() {
//        return isTiming ? 1 : 0;
//    }
}
