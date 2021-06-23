package cn.o0u0o.service.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@ApiModel(value="UUser对象", description="")
public class UUser extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户密码")
    private String userPasswd;

    @ApiModelProperty(value = "昵称")
    private String userName;

    @ApiModelProperty(value = "用户签名")
    private String userSign;

    @ApiModelProperty(value = "用户状态")
    private String status;

    @ApiModelProperty(value = "性别id")
    private String genderId;

    @ApiModelProperty(value = "生日")
    private Date birth;

    private Integer categoryId;


}
