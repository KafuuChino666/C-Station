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
@ApiModel(value="VVideoData对象", description="")
public class VVideoData extends BaseEntity {

    private static final long serialVersionUID=1L;

    private Integer vId;

    @ApiModelProperty(value = "播放数")
    private String playNub;

    @ApiModelProperty(value = "分享数")
    private String videoPnumb;

    @ApiModelProperty(value = "投币数")
    private Integer videoCoin;

    @ApiModelProperty(value = "点赞数")
    private String likeNumber;

    @ApiModelProperty(value = "点踩数")
    private String downNumber;


}
