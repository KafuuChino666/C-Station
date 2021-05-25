package cn.o0u0o.service.admin.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.admin.entity.vo.Select;
import cn.o0u0o.service.admin.entity.vo.UserData;
import cn.o0u0o.service.admin.service.UUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-23
 */
@RestController
@RequestMapping("/views/user")
public class UUserController {

    @Autowired
    private UUserService uUserService;

    @GetMapping(value = "/components/{page}/{limit}")
    public Result selectUserInfoAll(@PathVariable Integer page,
                                    @PathVariable Integer limit) {

        if(page > 0 && limit > 0) {
            IPage<UserData> userDataIPage = uUserService.selectUserAll(page, limit);
            return Result.ok().data("rows", userDataIPage);
        }
        return Result.err().message("页码不符合规则!");
    }

    /**
     * 请求参数：
     *     private Integer selectUserID;
     *     private Integer selectType;
     *     private String selectUserName;
     * @param page
     * @param limit
     * @return
     */
    @GetMapping(value = "/components/select/{page}/{limit}")
    public Result selectUserInfoBySelect(@PathVariable Integer page,
                                         @PathVariable Integer limit,
                                         @RequestParam(required = false) Integer selectUserID,
                                         @RequestParam(required = false) Integer selectType,
                                         @RequestParam(required = false) String selectUserName) {

        if(page > 0 && limit > 0) {
            IPage<UserData> selectIPage = uUserService.selectUserBySelect(page, limit, selectUserID, selectType, selectUserName);
            return Result.ok().data("rows", selectIPage);
        }
        return Result.err().message("页码错误！");
    }
}

