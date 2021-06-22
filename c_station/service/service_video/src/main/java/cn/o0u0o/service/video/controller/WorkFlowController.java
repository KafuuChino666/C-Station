package cn.o0u0o.service.video.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.common.util.TokenManager;
import cn.o0u0o.service.video.entity.WorkFlow;
import cn.o0u0o.service.video.service.WorkFlowService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    private TokenManager tokenManager;

    @Autowired
    private WorkFlowService workFlowService;

    @Autowired
    private RedisTemplate<String, Object> redisCacheTemplate;

    @ApiOperation("分页获取视频审核工作流")
    @GetMapping("/video/audit/work/{page}/{limit}")
    public Result getVideoAuditWork(@PathVariable Integer page, @PathVariable Integer limit) {

        IPage<WorkFlow> pageModel = workFlowService.getVideoAuditWork(page, limit);
        List<WorkFlow> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return  Result.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("根据名称搜索WorkFlow")
    @GetMapping("/work/search/{name}/{page}/{limit}")
    public Result searchWorkFlowByName(@PathVariable String name, @PathVariable Integer page, @PathVariable Integer limit) {

        if (!name.isEmpty()) {
            IPage<WorkFlow> pageModel = workFlowService.getWorkFlowByName(name, page, limit);
            List<WorkFlow> records = pageModel.getRecords();
            long total = pageModel.getTotal();
            return  Result.ok().data("total", total).data("rows", records);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("删除视频审核工作流")
    @DeleteMapping("/video/audit/work/")
    public Result removeVideoAuditWork(@RequestParam Integer id) {

        Boolean b = workFlowService.removeVideoAuditWork(id);
        return b ? Result.ok().message("删除成功!") : Result.err().message("删除失败,请检查该流程下是否有未审核完任务！");

    }

    @ApiOperation("根据id更新默认视频审核工作流")
    @PutMapping("/video/audit/work/{id}/{code}")
    public Result upDateWordUsable(@PathVariable Integer id, @PathVariable Integer code, HttpServletRequest request) {
        String username = tokenManager.getUserNameByToken(request);
        if (username == null) return Result.setResultCodeEnum(ResultCodeEnum.LOGIN_AUTH); // 需要登陆

        // 判断验证码
        BoundValueOperations<String, Object> sendAuthCount = redisCacheTemplate.boundValueOps("authCode_" + username);
        Integer authCode = (Integer) sendAuthCount.get();
        if (!authCode.equals(code)) { // 判断是否相等
            return Result.setResultCodeEnum(ResultCodeEnum.CODE_ERROR);
        }
        // 成功后删除
        redisCacheTemplate.delete("authCode_" + username);

        boolean b = workFlowService.upDateWordUsableById(id);
        return b ? Result.ok().message("更新成功!") : Result.err().message("删除失败,请检查该流程下是否有未审核完任务！");
    }

    @ApiOperation("校验流程名")
    @GetMapping("/acl/work/validate/{workFlowName}")
    public Result validateWorkFlowName(@PathVariable String workFlowName) {
        if (StringUtils.isEmpty(workFlowName)) {
            return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
        }

        boolean b = workFlowService.validateWorkFlowName(workFlowName);
        return b ? Result.ok().data("validate", true) : Result.ok().data("validate", false);
    }

    @ApiOperation("添加新流程")
    @PostMapping("/acl/work/")
    public Result addWorkFlow(@RequestBody WorkFlow workFlow) {
        boolean b = workFlowService.validateWorkFlowName(workFlow.getFlowName());
        if (b) {
            workFlow.setUsable(0);
            boolean save = workFlowService.save(workFlow);
            return save ? Result.ok() : Result.err().message("添加失败请稍后在试~");
        }
        return Result.err().message("流程名重复，请重新添加");
    }
}

