package cn.o0u0o.service.video.controller;

import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.video.entity.vo.QueryForm;
import cn.o0u0o.service.video.entity.vo.TableData;
import cn.o0u0o.service.video.service.VVideoInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Caleb Chen
 * @create 2021-05-03 17:11
 */
@Api(tags = "视频信息控制类")
@RestController
@CrossOrigin //跨域
@RequestMapping("/admin/video")
public class VVideoInfoController {

    @Autowired
    private VVideoInfoService vVideoInfoService;

    @ApiOperation("分页查询获取视频信息")
    @GetMapping(value = "/list/{page}/{limit}")
    public Result pageSelectVideoList(@PathVariable Integer page,
                                      @PathVariable Integer limit,
                                      @RequestParam(required = false) Integer videoId,
                                      @RequestParam(required = false) String videoTitle,
                                      @RequestParam(required = false) Integer authorId,
                                      @RequestParam(required = false) Date startTime,
                                      @RequestParam(required = false) Date endTime,
                                      @RequestParam(required = false) Long playNub,
                                      @RequestParam(required = false) String videoStatus) {

        IPage<TableData> queryFormIPage = vVideoInfoService.selectVideoByTerm(page, limit, videoId, videoTitle, authorId, startTime, endTime, playNub, videoStatus);
        List<TableData> records = queryFormIPage.getRecords();
        long total = queryFormIPage.getTotal();
        return  Result.ok().data("total", total).data("rows", records);
    }

}
