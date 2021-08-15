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
 * @since 2021-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="WorkFlowLine对象", description="")
public class WorkFlowLine extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "流程号")
    private Integer flowId;

    @ApiModelProperty(value = "前一节点编号")
    private Integer prevNodeId;

    @ApiModelProperty(value = "后一节点编号")
    private Integer nextNodeId;

    @ApiModelProperty(value = "备注")
    private String remark;


}
