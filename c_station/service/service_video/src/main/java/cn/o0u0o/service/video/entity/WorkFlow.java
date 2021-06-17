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
@ApiModel(value="WorkFlow对象", description="")
public class WorkFlow extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "流程名称")
    private String flowName;

    @ApiModelProperty(value = "默认")
    private Integer usable;

    @ApiModelProperty(value = "标记")
    private String sign;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String remark;


}
