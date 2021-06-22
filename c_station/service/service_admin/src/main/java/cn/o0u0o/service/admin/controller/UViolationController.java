package cn.o0u0o.service.admin.controller;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.admin.entity.vo.VioDes;
import cn.o0u0o.service.admin.service.UViolationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-06-22 8:45
 */
@Api(tags = "用户违规信息类")
@CrossOrigin //跨域
@RestController
@RequestMapping("/views/violation")
public class UViolationController {

    @Autowired
    private UViolationService uViolationService;

    /**
     * 根据userId查询违规信息
     * @param userId
     * @return
     */
    @GetMapping(value = "/marker/{id}")
    public Result selectVioDesById(@PathVariable(value = "id") Integer userId) {
        try {
            if(userId != null && userId > 0) {
                List<VioDes> vioDes = uViolationService.queryViolationById(userId);
                return vioDes != null ? Result.ok().data("rows", vioDes) : Result.setResultCodeEnum(ResultCodeEnum.FETCH_USERINFO_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.err().message("查询用户违规记录条件错误！");
    }

}
