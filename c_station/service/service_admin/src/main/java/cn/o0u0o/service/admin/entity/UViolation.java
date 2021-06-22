package cn.o0u0o.service.admin.entity;

import cn.o0u0o.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *
 * id int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
 * 	user_id int UNSIGNED,
 * 	vio_describe varchar(255) COMMENT '违规描述' not null,
 * 	vio_type int UNSIGNED COMMENT '违规类型' not null,
 * 	vio_video_id int UNSIGNED COMMENT '违规视频id',
 * 	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
 * 	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
 *
 * @author Caleb Chen
 * @create 2021-06-22 8:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UViolation对象", description="")
public class UViolation extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "违规描述")
    private String vioDescribe;

    @ApiModelProperty(value = "违规类型ID")
    private Integer vioType;

    @ApiModelProperty(value = "违规视频ID")
    private Integer vioVideoId;

}