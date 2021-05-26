package cn.o0u0o.service.admin.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.admin.entity.UCategory;
import cn.o0u0o.service.admin.service.UCategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-26
 */

@Api(tags = "会员控制类")
@CrossOrigin //跨域
@RestController
@RequestMapping("/views/category")
public class UCategoryController {

    @Autowired
    private UCategoryService uCategoryService;

    @GetMapping("/vip")
    public Result selectAllCategory() {
        List<UCategory> uCategories = uCategoryService.selectAllCategory();

        return Result.ok().data("rows", uCategories);
    }

}

