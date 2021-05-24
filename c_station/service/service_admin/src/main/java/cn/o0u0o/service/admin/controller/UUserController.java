package cn.o0u0o.service.admin.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.admin.entity.vo.UserData;
import cn.o0u0o.service.admin.service.UUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "components/select/{page}/{limit}")
    public Result selectUserInfoAll(@PathVariable Integer page,
                                    @PathVariable Integer limit) {
        IPage<UserData> userDataIPage = uUserService.selectUserAll(page, limit);

        return Result.ok().data("rows", userDataIPage);
    }

}

