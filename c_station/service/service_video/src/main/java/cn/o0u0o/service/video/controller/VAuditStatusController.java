package cn.o0u0o.service.video.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.util.TokenManager;
import cn.o0u0o.service.video.entity.VAuditStatus;
import cn.o0u0o.service.video.mapper.VAuditStatusMapper;
import cn.o0u0o.service.video.service.VAuditStatusService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-06-02
 */
@RestController
@RequestMapping("/admin/video/audit/status")
public class VAuditStatusController {

    @Autowired
    private VAuditStatusService vAuditStatusService;

    @Autowired
    private TokenManager tokenManager;

    @ApiOperation("锁定并返回一个视频审核任务")
    @GetMapping("/lock/{id}")
    public Result lockAuditVideo(@PathVariable Integer id, HttpServletRequest request) {

        String username = tokenManager.getUserNameByToken(request);
        // 判断是否有未完成任务
        Boolean b = vAuditStatusService.isUnfinished(username);
        if (b) {
            return Result.err().message("你有未完成的任务, 请完成任务后在试!");
        }
        b = vAuditStatusService.lockAuditVideo(username, id);
        return b ? Result.ok() : Result.err().message("任务锁定失败,重试或更换其他视频!");
    }

    @ApiOperation("获取未完成任务")
    @GetMapping("/unfinished")
    public Result getUnfinishedAudit(HttpServletRequest request) {
        String username = tokenManager.getUserNameByToken(request);
        Integer id = vAuditStatusService.getUnfinishedAudit(username);
        return Result.ok().data("id", id);
    }
}

