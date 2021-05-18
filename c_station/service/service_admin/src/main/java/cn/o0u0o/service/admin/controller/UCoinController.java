package cn.o0u0o.service.admin.controller;


import cn.o0u0o.service.admin.mapper.UCoinMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-04-20
 */
@Api(tags = "硬币控制类")
@RestController
@RequestMapping("/admin/u-coin")
public class UCoinController {

    @Autowired
    public UCoinMapper uCoinMapper;

    @RequestMapping
    public String asa() {
        uCoinMapper.textSelect();
        return "111";
    }
}

