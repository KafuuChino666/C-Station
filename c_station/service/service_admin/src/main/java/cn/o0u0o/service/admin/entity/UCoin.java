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
@ApiModel(value="UCoin对象", description="")
public class UCoin extends BaseEntity {

    private static final long serialVersionUID=1L;

      @TableId(value = "coin_id", type = IdType.AUTO)
    private Integer coinId;

    private Integer userId;

    @ApiModelProperty(value = "硬币余额")
    private Integer coinBalance;

    @ApiModelProperty(value = "投币信息")
    private String modifyCause;

    @ApiModelProperty(value = "投币数额")
    private Integer changeNumber;


}