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
 * @since 2021-06-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="VAuditStatus对象", description="")
public class VAuditStatus extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "视频id")
    private Integer vId;

    @ApiModelProperty(value = "流程号")
    private Integer flowId;

    @ApiModelProperty(value = "当前节点编号")
    private Integer currentNode;

    @ApiModelProperty(value = "审核员id(表示当前正在操作的审核员id)")
    private String auditor;

    @ApiModelProperty(value = "违纪说明")
    private String disciplineInfo;

    @ApiModelProperty(value = "审核状态(0: 为审核; 1: 审核通过; 2:未通过)")
    private Integer auditStatus;

    @ApiModelProperty(value = "视频审核员记录")
    private String auditorInfo;

    public VAuditStatus() {
    }

    public VAuditStatus(Integer vId, Integer flowId, Integer currentNode, String auditor, String disciplineInfo, Integer auditStatus, String auditorInfo) {
        this.vId = vId;
        this.flowId = flowId;
        this.currentNode = currentNode;
        this.auditor = auditor;
        this.disciplineInfo = disciplineInfo;
        this.auditStatus = auditStatus;
        this.auditorInfo = auditorInfo;
    }
}
