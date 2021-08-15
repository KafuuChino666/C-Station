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
@ApiModel(value="VVideoStatus对象", description="")
public class VVideoStatus extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "视频状态")
    private String videoStatus;


}
