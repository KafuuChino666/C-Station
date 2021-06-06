package cn.o0u0o.service.video.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.video.entity.WorkFlow;
import cn.o0u0o.service.video.service.WorkFlowService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class WorkFlowController {

    @Autowired
    private WorkFlowService workFlowService;

    @ApiOperation("分页获取视频审核工作流")
    @GetMapping("/video/audit/work/{page}/{limit}")
    public Result getVideoAuditWork(@PathVariable Integer page, @PathVariable Integer limit) {

        IPage<WorkFlow> pageModel = workFlowService.getVideoAuditWork(page, limit);
        List<WorkFlow> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return  Result.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("删除视频审核工作流")
    @DeleteMapping("/video/audit/work/")
    public Result removeVideoAuditWork(@RequestParam Integer id) {

        Boolean b = workFlowService.removeVideoAuditWork(id);
        return b ? Result.ok().message("删除成功!") : Result.err().message("删除失败,请检查该流程下是否有未审核完任务！");

    }
}

