package cn.o0u0o.service.admin.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.admin.entity.UCategory;
import cn.o0u0o.service.admin.service.UCategoryService;
import cn.o0u0o.service.admin.service.UUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private UUserService uUserService;

    /**
     * 查询所有用户类别
     * @return
     */
    @GetMapping("/vip")
    public Result selectAllCategory() {
        List<UCategory> uCategories = uCategoryService.selectAllCategory();

        return Result.ok().data("category", uCategories);
    }

    /**
     * 注销用户
     * @param id
     * @return
     */
    @PutMapping("/remove/{id}")
    public Result removeUserById(@PathVariable Integer id) {
        Map<String, Integer> typeMap = new HashMap<>();
        typeMap.put("category_id", null);
        if(id != null && id <= uUserService.selectUserCount(typeMap)) {
            Boolean b = uCategoryService.removeUserCategoryByID(id);
            return b ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
        }
        return Result.err().message("用户类别号错误！");
    }

    /**
     * 解除注销用户
     * @param id
     * @return
     */
    @PutMapping("/unRemove/{id}")
    public Result unRemoveUserById(@PathVariable Integer id) {
        Map<String, Integer> typeMap = new HashMap<>();
        typeMap.put("category_id", null);
        if(id != null && id <= uUserService.selectUserCount(typeMap)) {
            Boolean b = uCategoryService.unRemoveUserCategoryByID(id);
            return b ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
        }
        return Result.err().message("用户类别号错误！");
    }

    /**
     * 根据用户ID查询类型编号
     * @param id
     * @return
     */
    @GetMapping("/select/categoryId/{id}")
    public Result selectCategoryIdByID(@PathVariable Integer id) {
        Integer categoryId = uCategoryService.queryCategoryByID(id);
        if(categoryId > 0) {
            return Result.ok().data("cateId", categoryId);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.FETCH_USERINFO_ERROR);
    }

}

