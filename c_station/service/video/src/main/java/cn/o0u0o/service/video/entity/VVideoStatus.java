package cn.o0u0o.service.video.entity;

import cn.o0u0o.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Caleb Chen
 * @create 2021-04-21 21:30
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="VVideoStatus对象", description="")
public class VVideoStatus extends BaseEntity {

    private static final long serialVersionUID=1L;

    @TableId(value = "video_status_id", type = IdType.AUTO)
    @ApiModelProperty(value = "视频状态id")
    private Integer videoStatusId;

    @ApiModelProperty(value = "视频状态")
    private String videoStatus;
}
