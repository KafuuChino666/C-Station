package cn.o0u0o.service.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import cn.o0u0o.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="URealname对象", description="")
public class URealname extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @ApiModelProperty(value = "身份证号")
    @TableField("ID_number")
    private String idNumber;


}
