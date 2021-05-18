package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VVideoInfo;
import cn.o0u0o.service.video.entity.vo.QueryForm;
import cn.o0u0o.service.video.entity.vo.TableData;
import cn.o0u0o.service.video.entity.vo.VideoInfoForm;
import cn.o0u0o.service.video.entity.vo.VideoInfoResult;
import cn.o0u0o.service.video.mapper.VVideoInfoMapper;
import cn.o0u0o.service.video.service.VVideoInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Caleb Chen
 * @since 2021-05-17
 */
@Service
public class VVideoInfoServiceImpl extends ServiceImpl<VVideoInfoMapper, VVideoInfo> implements VVideoInfoService {

    @Autowired
    private VVideoInfoMapper vVideoInfoMapper;

    @Override
    public IPage<TableData> selectVideoByTerm(Integer page, Integer limit, Integer videoId, String videoTitle, Integer authorId, Date startTime, Date endTime, String playNub, Integer videoStatus) {
        Page<QueryForm> pageParam = new Page<>(page, limit);
        return vVideoInfoMapper.selectVideoByTerm(pageParam, videoId, videoTitle, authorId, startTime, endTime, playNub, videoStatus);
    }

    @Override
    public VideoInfoResult getVideoInfoById(Integer videoId) {
        VideoInfoForm videoInfoById = vVideoInfoMapper.getVideoInfoById(videoId);

        // 计算页面实际显示点赞数
        String likeNumber = videoInfoById.getLikeNumber();
        String downNumber = videoInfoById.getDownNumber();
        Long like = Long.parseLong(likeNumber);
        Long down = Long.parseLong(downNumber);
        Long likeNub = 0L;

        if((like - down) >= 0) {
            likeNub = like - down;
        }

        String likeNumb = Long.toString(likeNub);

        //获取信息
        Integer authorId = videoInfoById.getAuthorId();
        String userName = videoInfoById.getUserName();
        String videoTitle = videoInfoById.getVideoTitle();
        String videoBrief = videoInfoById.getVideoBrief();
        Date gmtCreate = videoInfoById.getGmtCreate();
        String playNub = videoInfoById.getPlayNub();
        String videoPnumb = videoInfoById.getVideoPnumb();
        Integer videoCoin = videoInfoById.getVideoCoin();
        List<String> zoneType = videoInfoById.getZoneType();
        Integer videoStatus = videoInfoById.getVideoStatus();


        VideoInfoResult videoInfoResult
                = new VideoInfoResult(videoId, authorId, userName, videoTitle, videoBrief, gmtCreate, playNub, videoPnumb, videoCoin, likeNumb, zoneType, videoStatus);

        return videoInfoResult;
    }

    @Override
    public List<VVideoInfo> selectAllVideoStatus() {
        List<VVideoInfo> statusList = vVideoInfoMapper.selectAllVideoStatus();
        return statusList;
    }
}
