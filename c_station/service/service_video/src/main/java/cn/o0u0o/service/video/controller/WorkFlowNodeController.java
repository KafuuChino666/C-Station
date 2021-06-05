package cn.o0u0o.service.video.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.video.entity.WorkFlowNode;
import cn.o0u0o.service.video.service.WorkFlowNodeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-06-02
 */
@RestController
@RequestMapping("/admin")
public class WorkFlowNodeController {

    @Autowired
    private WorkFlowNodeService workFlowNodeService;

    @ApiOperation("根据流程获取节点")
    @GetMapping("/video/audit/flow/{id}")
    public Result getNodesByFlowId(@PathVariable Integer id) {
        List<WorkFlowNode> workFlowNodes = workFlowNodeService.getNodesByFlowId(id);
        return Result.ok().data("list", workFlowNodes);
    }
}

