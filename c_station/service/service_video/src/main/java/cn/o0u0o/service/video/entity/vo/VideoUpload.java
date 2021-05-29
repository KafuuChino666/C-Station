package cn.o0u0o.service.video.entity.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 视频投稿相关字段
 */
@Data
public class VideoUpload {

    @NotEmpty(message = "参数不能为空")
    private String videoId;
    private Boolean isInnovate;
    @NotEmpty(message = "参数不能为空")
    private String coverUrl;
    @NotEmpty(message = "参数不能为空")
    @Length(min = 3, max = 30, message = "标题过长或过短")
    private String videoTitle;
    @Size(min = 2, max = 2)
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
    @Future(message = "时间必须在当前之后")
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
