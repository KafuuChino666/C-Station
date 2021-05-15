package cn.o0u0o.service.video.entity;

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
 * @author Caleb Chen
 * @since 2021-04-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("v_video_info")
@ApiModel(value="VVideoInfo对象", description="")
public class VVideoInfo extends BaseEntity {

    private static final long serialVersionUID=1L;

      @TableId(value = "video_info_id", type = IdType.AUTO)
      @ApiModelProperty(value = "视频信息id")
    private Integer videoInfoId;

    @ApiModelProperty(value = "点赞id")
    private Integer likeId;

    @ApiModelProperty(value = "播放数")
    private String playNub;

    @ApiModelProperty(value = "分享数")
    private String videoPnumb;

    @ApiModelProperty(value = "投币数")
    private String videoCoin;

    @ApiModelProperty(value = "视频标题")
    private String videoTitle;

    @ApiModelProperty(value = "视频简介")
    private String videoBrief;

    @ApiModelProperty(value = "审核id")
    private Integer auditId;

    @ApiModelProperty(value = "视频状态编号")
    private Integer videoStatus;


}
