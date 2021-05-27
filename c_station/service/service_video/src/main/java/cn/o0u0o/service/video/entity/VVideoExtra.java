package cn.o0u0o.service.video.entity;

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
 * @author Guo Yangyang
 * @since 2021-05-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="VVideoExtra对象", description="")
public class VVideoExtra extends BaseEntity {

    private static final long serialVersionUID=1L;

    private Integer vId;

    @ApiModelProperty(value = "标签")
    private String tags;

    @ApiModelProperty(value = "自制声明")
    private Integer isInnovate;

    @ApiModelProperty(value = "开启专属水印")
    private Integer isWatermark;

    @ApiModelProperty(value = "字幕")
    private String videoCaption;

    @ApiModelProperty(value = "商业声明")
    private Integer isCommerce;

    @ApiModelProperty(value = "允许观众投稿字幕")
    private Integer restsCastCaption;

    @ApiModelProperty(value = "粉丝动态")
    private String fanDynamic;

    @ApiModelProperty(value = "定时发布")
    private Integer isTiming;

    @ApiModelProperty(value = "定时时间")
    private Date timingTime;


}
