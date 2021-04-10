package cn.o0u0o.service.entity;

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
 * @since 2021-04-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="USafe对象", description="")
public class USafe extends BaseEntity {

    private static final long serialVersionUID=1L;

      @TableId(value = "safe_id", type = IdType.AUTO)
    private Integer safeId;

    private Integer userId;

    private String email;

    private Integer phone;

    private Integer epId;

    private Integer rnId;


}
