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
 * @since 2021-05-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UIntegral对象", description="")
public class UIntegral extends BaseEntity {

    private static final long serialVersionUID=1L;

    private Integer userId;

    @ApiModelProperty(value = "积分余额")
    private Integer igBalance;

    @ApiModelProperty(value = "消费原因")
    private String modifyCause;

    @ApiModelProperty(value = "消费数额")
    private Integer changeNumber;


}
