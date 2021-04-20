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
@ApiModel(value="USubscription对象", description="")
public class USubscription extends BaseEntity {

    private static final long serialVersionUID=1L;

      @TableId(value = "subscription_id", type = IdType.AUTO)
    private Integer subscriptionId;

    private Integer userId;

    private Integer subSitcomId;

    private Integer subBangumiId;

    private Integer labelId;


}
