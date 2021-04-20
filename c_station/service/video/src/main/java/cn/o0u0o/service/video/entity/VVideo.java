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
    private Integer videoId;

    private Integer authorId;

    private Integer commentId;

    private Integer videoInfoId;

    @ApiModelProperty(value = "视频信息")
    private String videoLocation;

    private Integer imgId;

    private Integer zoneId;


}
