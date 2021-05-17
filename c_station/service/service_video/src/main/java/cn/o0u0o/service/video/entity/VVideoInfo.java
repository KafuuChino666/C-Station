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
 * @author Caleb Chen
 * @since 2021-05-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="VVideoInfo对象", description="")
public class VVideoInfo extends BaseEntity {

    private static final long serialVersionUID=1L;

    private String likeId;

    @ApiModelProperty(value = "播放数")
    private String playNub;

    @ApiModelProperty(value = "分享数")
    private String videoPnumb;

    @ApiModelProperty(value = "投币数")
    private Integer videoCoin;

    private Integer auditId;

    private Integer videoStatus;


}
