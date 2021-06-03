package cn.o0u0o.service.video.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import cn.o0u0o.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="VVideo对象", description="")
public class VVideo extends BaseEntity {

    private static final long serialVersionUID=1L;

    private String authorId;

    private Integer zoneId;

    private String imgUrl;

    @ApiModelProperty(value = "视频标题")
    private String videoTitle;

    @ApiModelProperty(value = "视频简介")
    private String videoBrief;

    private Integer videoStatus;

    public VVideo() {
    }

    public VVideo(String authorId, Integer zoneId, String imgUrl, String videoTitle, String videoBrief, Integer videoStatus) {
        this.authorId = authorId;
        this.zoneId = zoneId;
        this.imgUrl = imgUrl;
        this.videoTitle = videoTitle;
        this.videoBrief = videoBrief;
        this.videoStatus = videoStatus;
    }
}
