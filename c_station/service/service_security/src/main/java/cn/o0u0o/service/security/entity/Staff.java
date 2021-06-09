package cn.o0u0o.service.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import cn.o0u0o.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("acl_staff")
@ApiModel(value="Staff对象", description="")
public class Staff extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "备注信息")
    private String remark;

    @ApiModelProperty(value = "帐号启用状态：0：禁用；1：启用")
    private Boolean status;


    public void setStatus(Integer status) {
        this.status = status == 1 ;
    }

    public Staff() {
    }

    public Staff(String username, String password, String icon, String email, String mobile, String nickName, String remark, Boolean status) {
        this.username = username;
        this.password = password;
        this.icon = icon;
        this.email = email;
        this.mobile = mobile;
        this.nickName = nickName;
        this.remark = remark;
        this.status = status;
    }
}
