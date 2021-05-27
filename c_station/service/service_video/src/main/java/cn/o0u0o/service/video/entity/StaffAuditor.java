package cn.o0u0o.service.video.entity;

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
 * @since 2021-05-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="StaffAuditor对象", description="")
public class StaffAuditor extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "员工id")
    private Integer staffId;

    @ApiModelProperty(value = "审核类型")
    private Integer auditType;

    @ApiModelProperty(value = "今日审核数")
    private Integer auditNumToday;

    @ApiModelProperty(value = "本月审核数")
    private Integer auditNumMonth;


}
