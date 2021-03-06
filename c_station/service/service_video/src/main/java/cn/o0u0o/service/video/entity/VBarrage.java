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
@ApiModel(value="VBarrage对象", description="")
public class VBarrage extends BaseEntity {

    private static final long serialVersionUID=1L;

    private Integer userId;

    private Integer videoId;

    @ApiModelProperty(value = "弹幕内容")
    private String barrageStr;

    @ApiModelProperty(value = "视频时间")
    private Date videoTime;


}
