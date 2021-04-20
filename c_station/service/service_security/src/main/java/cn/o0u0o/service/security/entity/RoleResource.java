package cn.o0u0o.service.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import cn.o0u0o.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
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
@TableName("acl_role_resource")
@ApiModel(value="RoleResource对象", description="")
public class RoleResource extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "角色ID")
    private String roleId;

    @ApiModelProperty(value = "资源ID")
    private String resourceId;
    public RoleResource() {
    }

    public RoleResource(String roleId, String resourceId) {
        this.roleId = roleId;
        this.resourceId = resourceId;
    }
}
