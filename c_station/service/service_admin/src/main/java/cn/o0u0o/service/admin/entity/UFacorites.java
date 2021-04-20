package cn.o0u0o.service.admin.entity;

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
@ApiModel(value="UFacorites对象", description="")
public class UFacorites extends BaseEntity {

    private static final long serialVersionUID=1L;

      @TableId(value = "facorites_id", type = IdType.AUTO)
    private Integer facoritesId;

    private Integer userId;

    @ApiModelProperty(value = "收藏夹名")
    private String facoritesName;

    private Integer collectId;

    private Integer videoId;

    @ApiModelProperty(value = "收藏夹状态")
    private String facoritesStatus;


}
