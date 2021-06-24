package cn.o0u0o.service.admin.entity;

import cn.o0u0o.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Caleb Chen
 * @create 2021-06-23 21:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UGender对象", description="")
public class UGender extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "会员类型")
    private String gender;

}
