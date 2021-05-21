package cn.o0u0o.service.video.controller;


import cn.o0u0o.common.response.Result;
import cn.o0u0o.service.video.entity.VVideoInfo;
import cn.o0u0o.service.video.entity.VVideoStatus;
import cn.o0u0o.service.video.entity.vo.TableData;
import cn.o0u0o.service.video.entity.vo.VideoInfoResult;
import cn.o0u0o.service.video.mapper.VVideoInfoMapper;
import cn.o0u0o.service.video.service.VVideoInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-17
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
                                      @RequestParam(required = false) Integer id,
                                      @RequestParam(required = false) String videoTitle,
                                      @RequestParam(required = false) Integer authorId,
                                      @RequestParam(required = false) Date startTime,
                                      @RequestParam(required = false) Date endTime,
                                      @RequestParam(required = false) String playNub,
                                      @RequestParam(required = false) Integer videoStatus) {

        IPage<TableData> queryFormIPage = vVideoInfoService.selectVideoByTerm(page, limit, id, videoTitle, authorId, startTime, endTime, playNub, videoStatus);
        List<TableData> records = queryFormIPage.getRecords(); // 分页记录列表
        long total = queryFormIPage.getTotal(); // 分页总条数
        return  Result.ok().data("total", total).data("rows", records);
    }

    @ApiOperation("根据视频id获取视频信息")
    @GetMapping(value = "/info/{id}")
    public Result getVideoInfoById(@PathVariable Integer id) {
        VideoInfoResult videoInfoById = vVideoInfoService.getVideoInfoById(id);

        Result err = Result.err();
        if(id <= 0) {
            return err.message("视频ID不正确");
        }
        if(videoInfoById == null) {
            return err.message("未找到视频信息！");
        }

        return Result.ok().data("videoInfo", videoInfoById);

    }

    @ApiOperation("获取所有视频状态")
    @GetMapping(value = "/status")
    public Result selectAllVideoStatus() {
        List<VVideoStatus> statusList = vVideoInfoService.selectAllVideoStatus();
        return Result.ok().data("statusList", statusList);
    }


//    @Autowired
//    public VVideoInfoMapper vVideoInfoMapper;

//    @GetMapping("/test")
//    public Object test() {
//        return vVideoInfoMapper.test();
//    }

}


