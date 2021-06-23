package cn.o0u0o.service.video.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.common.util.TokenManager;
import cn.o0u0o.service.video.entity.VAuditStatus;
import cn.o0u0o.service.video.entity.vo.VideoAuditListItem;
import cn.o0u0o.service.video.service.VAuditService;
import cn.o0u0o.service.video.service.VAuditStatusService;
import cn.o0u0o.service.video.service.WorkFlowNodeRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-26
 */
@RestController
@RequestMapping("/admin/video/audit/")
public class VAuditController {

    @Autowired
    public VAuditService vAuditService;
    
    @Autowired
    public TokenManager tokenManager;

    @Autowired
    public WorkFlowNodeRoleService workFlowNodeRoleService;

    @Autowired
    public VAuditStatusService vAuditStatusService;

    /**
     * 该接口会根据所请求角
     * @return 统一返回
     */
    @ApiOperation("视频审核接口")
    @GetMapping("/")
    public Result getOneVideoAudit(HttpServletRequest httpServletRequest) {

        // 根据toker获取角色/uuid
        // 要根据角色/id确定该审核员所在节点 ---》 需要将角色/id和节点进行绑定（可能需要新表支撑）
        String username = tokenManager.getUserNameByToken(httpServletRequest);
        // 获取节点id
        Integer nodeId = workFlowNodeRoleService.getNodeIdByUserName(username);
        // 判断id
        if (nodeId == null) {
            return Result.err().message("未找到您的审核节点, 查看账号是否有审核权限！");
        }
        // 确定是否有 该审核员 锁定审核视频，但未审核完成
        // 如果有 则继续将其返回给该审核员

        // 确定审核节点

        // 获取该节点最早时间视频

        // 数据库行锁; 修改字段auditor_id

        // 返回给前端 ----》 审核员进行审核

        return Result.err();
    }

    @ApiOperation("获取该审核员节点下的审核列表")
    @GetMapping("/list")
    public Result getAuditListByUserName(HttpServletRequest request) {
        String username = tokenManager.getUserNameByToken(request);
        if (username == null) return Result.setResultCodeEnum(ResultCodeEnum.LOGIN_AUTH);

        Integer nodeId = workFlowNodeRoleService.getNodeIdByUserName(username);
        // 判断id
        if (nodeId == null) {
            return Result.err().message("未找到您的审核节点, 查看账号是否有审核权限！");
        }
        // 获取审核列表
        List<VideoAuditListItem> vAuditStatuses = vAuditStatusService.getListByNodeId(nodeId);
        return Result.ok().data("rows", vAuditStatuses);
    }
}

