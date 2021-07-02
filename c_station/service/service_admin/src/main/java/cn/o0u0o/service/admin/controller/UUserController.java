package cn.o0u0o.service.admin.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.common.response.ResultCodeEnum;
import cn.o0u0o.service.admin.entity.UCategory;
import cn.o0u0o.service.admin.entity.UUser;
import cn.o0u0o.service.admin.entity.vo.EditUserData;
import cn.o0u0o.service.admin.entity.vo.Select;
import cn.o0u0o.service.admin.entity.vo.UserData;
import cn.o0u0o.service.admin.service.UCategoryService;
import cn.o0u0o.service.admin.service.UGenderService;
import cn.o0u0o.service.admin.service.UUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-23
 */
@Api(tags = "用户信息控制类")
@CrossOrigin //跨域
@RestController
@RequestMapping("/views/user")
public class UUserController {

    @Autowired
    private UCategoryService uCategoryService;
    @Autowired
    private UUserService uUserService;
    @Autowired
    private UGenderService uGenderService;

    /**
     * 请求参数：
     *     private Integer selectUserID;
     *     private Integer selectType;
     *     private String selectUserName;
     * @param page 页码
     * @param limit 每页显示的数量
     * @return
     */
    @PostMapping(value = "/components/select/{page}/{limit}")
    public Result selectUserInfoBySelect(@PathVariable Integer page,
                                         @PathVariable Integer limit,
                                         @RequestBody(required = false) Select select) {

        // 判断是否有查询条件
        if(select == null) {
            if(page > 0 && limit > 0) {
                IPage<UserData> userDataIPage = uUserService.selectUserAll(page, limit);
                List<UserData> records = userDataIPage.getRecords();
                long total = userDataIPage.getTotal();
                System.out.println(total + " 1");
                return Result.ok().data("total", total).data("rows", records);
            }
        } else {
            if(page > 0 && limit > 0) {
                IPage<UserData> selectIPage = uUserService.selectUserBySelect(page, limit, select);
                List<UserData> records = selectIPage.getRecords();
                long total = selectIPage.getTotal();
                System.out.println(total);
                return Result.ok().data("total", total).data("rows", records);
            }
        }
        return Result.err().message("用户查询页码错误！");
    }

    /**
     * 根据用户ID查询需要编辑的数据
     * @return
     */
    @GetMapping(value = "/show/{id}")
    public Result editShowUserByID(@PathVariable Integer id) {
        if(id > 0) {
            EditUserData editUserDataID = uUserService.queryUserDataByID(id);
            return Result.ok().data("editData", editUserDataID);
        }
        return Result.err().message("用户id错误！");
    }


    /**
     * 修改用户资料
     * @param editUserData 要修改的用户资料
     * @return
     */
    @PutMapping(value = "update/{id}")
    public Result editUserByID(@RequestBody EditUserData editUserData, @PathVariable Integer id) {
        if(editUserData != null && id > 0) {
            Integer result = uUserService.editUserByID(editUserData, id);
            return Result.ok().data("result", result);
        }
        return Result.setResultCodeEnum(ResultCodeEnum.EXCEL_DATA_IMPORT_ERROR);
    }

}

