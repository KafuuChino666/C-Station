package cn.o0u0o.service.video.entity;

import cn.o0u0o.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="PubZone对象", description="")
public class PubZone extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "标题")
    @NotBlank(message = "title 不能为空!")
    private String title;

    @ApiModelProperty(value = "备注")
    private String notes;

    @ApiModelProperty(value = "父级ID")
    @NotNull(message = "parentId 不能为空!")
    private Integer parentId;

    @ApiModelProperty(value = "分区级数")
    @NotNull(message = "level 不能为空!")
    @Min(value = 0)
    @Max(value = 1)
    private Integer level;

    @ApiModelProperty(value = "分区排序")
    private Integer sort;

    @ApiModelProperty(value = "逻辑删除")
    private Integer isDelete;


}
