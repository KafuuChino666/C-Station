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
@ApiModel(value="PubImg对象", description="")
public class PubImg extends BaseEntity {

    private static final long serialVersionUID=1L;

      @TableId(value = "img_id", type = IdType.AUTO)
    private Integer imgId;

    private String imgLocation;

    private Integer userId;

    private Integer imgType;


}
