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
 * @author Caleb Chen
 * @since 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="VVideoText对象", description="")
public class VVideoText extends BaseEntity {

    private static final long serialVersionUID=1L;

      @TableId(value = "video_text_id", type = IdType.AUTO)
    private Integer videoTextId;

    private Integer videoInfoId;

    private Integer zoneId;

    private Integer imgId;

    private Integer authorId;

    private Integer commentId;

    @ApiModelProperty(value = "视频标题")
    private String videoTitle;

    @ApiModelProperty(value = "视频简介")
    private String videoBrief;


}
