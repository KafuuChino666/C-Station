package cn.o0u0o.service.video.controller;


import cn.o0u0o.common.response.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-05-26
 */
@RestController
@RequestMapping("/v-audit")
public class VAuditController {

    /**
     * 该接口会根据所请求角
     * @return 统一返回
     */
    @ApiOperation("视频审核接口")
    @GetMapping("/")
    public Result getOneVideoAudit() {

        // 根据toker获取角色/uuid
        // 要根据角色/id确定该审核员所在节点 ---》 需要将角色/id和节点进行绑定（可能需要新表支撑）

        // 确定是否有 该审核员 锁定审核视频，但未审核完成
        // 如果有 则继续将其返回给该审核员

        // 确定审核节点

        // 获取该节点最早时间视频

        // 数据库行锁; 修改字段auditor_id

        // 返回给前端 ----》 审核员进行审核

        return Result.err();
    }
}

