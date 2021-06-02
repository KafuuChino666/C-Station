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
 * @since 2021-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="WorkFlowNode对象", description="")
public class WorkFlowNode extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "流程号")
    private Integer flowId;

    @ApiModelProperty(value = "流程节点名称")
    private String flowNodeName;

    @ApiModelProperty(value = "流程角色")
    private Integer flowNodeRole;

    @ApiModelProperty(value = "备注")
    private String remark;


}
