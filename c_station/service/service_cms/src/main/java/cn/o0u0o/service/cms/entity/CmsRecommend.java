package cn.o0u0o.service.cms.entity;

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
 * @since 2021-08-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="CmsRecommend对象", description="")
public class CmsRecommend extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "视频id")
    private Long vId;

    @ApiModelProperty(value = "推送优先级")
    private Integer priority;


}
