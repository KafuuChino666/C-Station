package cn.o0u0o.service.video.entity;

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
@ApiModel(value="VVideoItem对象", description="")
public class VVideoItem extends BaseEntity {

    private static final long serialVersionUID=1L;

    private Integer vId;

    private Integer videoSort;

    private String videoTitle;

    private String videoDuration;

    @ApiModelProperty(value = "视频信息")
    private String videoLocation;

    private Integer auditId;

    private Integer videoStatus;

    public VVideoItem() {
    }

    public VVideoItem(Integer vId, Integer videoSort, String videoTitle, String videoDuration, String videoLocation, Integer auditId, Integer videoStatus) {
        this.vId = vId;
        this.videoSort = videoSort;
        this.videoTitle = videoTitle;
        this.videoDuration = videoDuration;
        this.videoLocation = videoLocation;
        this.auditId = auditId;
        this.videoStatus = videoStatus;
    }
}
