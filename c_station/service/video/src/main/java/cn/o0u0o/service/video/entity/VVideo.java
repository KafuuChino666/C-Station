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
 * @since 2021-04-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="VVideo对象", description="")
public class VVideo extends BaseEntity {

    private static final long serialVersionUID=1L;

      @TableId(value = "video_id", type = IdType.AUTO)
      @ApiModelProperty(value = "视频id")
    private Integer videoId;

    @ApiModelProperty(value = "作者id")
    private Integer authorId;

    @ApiModelProperty(value = "评论id")
    private Integer commentId;

    @ApiModelProperty(value = "视频信息id")
    private Integer videoInfoId;

    @ApiModelProperty(value = "视频地址")
    private String videoLocation;

    @ApiModelProperty(value = "图片id(封面)")
    private Integer imgId;

    @ApiModelProperty(value = "分区id")
    private Integer zoneId;


}
