package cn.o0u0o.service.admin.entity;

import cn.o0u0o.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Caleb Chen
 * @create 2021-06-22 9:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UVioType对象", description="")
public class UVioType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "违规类型")
    private String vioType;

}
