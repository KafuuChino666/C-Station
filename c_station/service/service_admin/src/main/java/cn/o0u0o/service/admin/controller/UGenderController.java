package cn.o0u0o.service.admin.controller;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.admin.entity.UGender;
import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.service.UGenderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-06-23 21:01
 */
@Api(tags = "性别控制类")
@CrossOrigin //跨域
@RestController
@RequestMapping("/views/gender")
public class UGenderController {

    @Autowired
    private UGenderService uGenderService;

    /**
     * 查询所有性别
     * @return
     */
    @GetMapping("/sex")
    public Result selectAllGender() {
        List<UGender> uGenders = uGenderService.selectAllGender();
        return Result.ok().data("gender", uGenders);
    }


    @GetMapping("/select/sex/{id}")
    public Result selectGenderByGenderID(@PathVariable Integer id) {
        if(id > 0) {
            String gender = uGenderService.selectGenderByGenderID(id);
            if(gender != null) {
                return Result.ok().data("genderByID", gender);
            }
        }
        return Result.setResultCodeEnum(ResultCodeEnum.FETCH_USERINFO_ERROR);
    }

}
