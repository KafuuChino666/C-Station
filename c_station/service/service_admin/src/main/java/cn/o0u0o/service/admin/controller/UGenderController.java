package cn.o0u0o.service.admin.controller;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.admin.entity.UGender;
import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.service.UGenderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/sex")
    public Result selectAllGender() {
        List<UGender> uGenders = uGenderService.selectAllGender();

        return Result.ok().data("gender", uGenders);
    }

}
