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
@ApiModel(value="VLike对象", description="")
public class VLike extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "点赞数")
    private String likeNumber;

    @ApiModelProperty(value = "点踩数")
    private String downNumber;


}
