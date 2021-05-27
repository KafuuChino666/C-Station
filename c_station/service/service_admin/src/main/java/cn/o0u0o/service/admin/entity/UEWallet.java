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
@ApiModel(value="UEWallet对象", description="")
public class UEWallet extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "c币余额")
    private Integer cMoney;

    @ApiModelProperty(value = "c币总数")
    private Integer cTotal;

    private Integer userId;

    private Integer orderId;

    @ApiModelProperty(value = "消费类型")
    private String expendType;

    @ApiModelProperty(value = "消费信息")
    private String modifyCause;


}
