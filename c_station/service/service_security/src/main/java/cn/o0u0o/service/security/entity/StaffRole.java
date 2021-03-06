package cn.o0u0o.service.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @author Guo Yangyang
 * @since 2021-04-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("acl_staff_role")
@ApiModel(value="StaffRole对象", description="")
public class StaffRole extends BaseEntity {

    private static final long serialVersionUID=1L;

    private String staffId;

    private String roleId;

    public StaffRole(String staffId, String roleId) {
        this.staffId = staffId;
        this.roleId = roleId;
    }

    public StaffRole() {
    }
}
