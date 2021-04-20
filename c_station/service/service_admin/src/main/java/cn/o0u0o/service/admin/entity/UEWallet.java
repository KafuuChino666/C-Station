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
@ApiModel(value="UEWallet对象", description="")
public class UEWallet extends BaseEntity {

    private static final long serialVersionUID=1L;

      @TableId(value = "wallet_id", type = IdType.AUTO)
    private Integer walletId;

    @ApiModelProperty(value = "c币余额")
    private Integer cMoney;

    private Integer userId;

    private Integer orderId;

    @ApiModelProperty(value = "消费类型")
    private String expendType;

    @ApiModelProperty(value = "消费信息")
    private String modifyCause;


}
