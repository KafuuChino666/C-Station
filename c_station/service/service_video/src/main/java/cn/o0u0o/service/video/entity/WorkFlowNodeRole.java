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
 * @since 2021-06-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="WorkFlowNodeRole对象", description="")
public class WorkFlowNodeRole extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "节点号")
    private Integer nodeId;

    @ApiModelProperty(value = "角色id")
    private Integer roleId;


}
