package cn.o0u0o.service.security.controller;


import cn.o0u0o.service.security.entity.Menu;
import cn.o0u0o.service.security.entity.Resource;
import cn.o0u0o.service.security.entity.vo.MenuVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.security.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Guo Yangyang
 * @since 2021-04-08
 */
@RestController
@CrossOrigin //跨域
@RequestMapping("/admin/acl/menu")
public class MenuController {

    @Autowired
    public MenuService menuService;

    @ApiOperation("修改菜单隐藏状态")
    @PutMapping("/hidden/")
    public Result updateMenuHidden(@RequestParam String id, @RequestParam Boolean status) {
        boolean b = menuService.updateHiddenById(id, status);
        return b ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
    }

    @ApiOperation("分页获取菜单")
    @GetMapping("/list/{page}/{limit}")
    public Result pageMenuList(@PathVariable Integer page, @PathVariable Integer limit) {
        IPage<Menu> pageModel = menuService.selectPage(page, limit);
        List<Menu> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return  Result.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("获取所有菜单")
    @GetMapping("/")
    public Result getList() {
        List<Menu> list = menuService.getIdAndName();
        return Result.ok().data("rows", list);
    }

    @ApiOperation("添加菜单")
    @PostMapping("/")
    public Result addMrnu(@RequestBody Menu menu) {
        boolean b = menuService.add(menu);
        return b ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
    }

    @ApiOperation("更新菜单")
    @PutMapping("/")
    public Result updateMenuById(@RequestBody Menu menu) {
        boolean b = menuService.updateById(menu);
        return b ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
    }

    @ApiOperation("根据id删除菜单")
    @DeleteMapping("/")
    public Result reomveMenuById(@RequestBody String id) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(id.trim()).matches()) {
            boolean b = menuService.deleted(id);
            return b ? Result.ok() : Result.setResultCodeEnum(ResultCodeEnum.UNKNOWN_REASON);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("根据名称搜索菜单")
    @GetMapping("/seek/{name}")
    public Result getMenuByName(@PathVariable String name) {
        name = name.trim();
        if (!name.isEmpty()) {
            List<Menu> menus = menuService.getByName(name);
            return Result.ok().data("rows", menus);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.PARAM_ERROR);
    }

    @ApiOperation("返回层级格式列表")
    @GetMapping("/hierarchy")
    public Result getHierarchyMenuList() {
        List<MenuVo> menuVos = menuService.getHierarchyMenu();
        return Result.ok().data("rows", menuVos);
    }

    @ApiOperation("根据ParentId返回子集菜单")
    @GetMapping("/parent_id/{id}")
    public Result getMenuByParentId(@PathVariable String id) {
        List<Menu> menus = menuService.getMenuByParentId(id);
        return Result.ok().data("rows", menus);
    }
}

