package cn.o0u0o.service.cms.entity;

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
 * @author Guo Yangyang
 * @since 2021-08-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="CmsCarousel对象", description="")
public class CmsCarousel extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "文字内容")
    private String content;

    @ApiModelProperty(value = "图片url")
    @TableField("img_Url")
    private String imgUrl;

    @ApiModelProperty(value = "跳转链接")
    private String link;

    @ApiModelProperty(value = "顺序")
    private Integer rank;

    @ApiModelProperty(value = "是否显示")
    private Integer reveal;


}
