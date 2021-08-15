package cn.o0u0o.service.video.entity;

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
@ApiModel(value="VAudit对象", description="")
public class VAudit extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "审核员id")
    private Integer auditorId;

    @ApiModelProperty(value = "违纪说明")
    private String disciplineInfo;

    @ApiModelProperty(value = "视频审核员记录")
    private String auditorInfo;

    @ApiModelProperty(value = "审核状态")
    private Integer auditStatus;


}
