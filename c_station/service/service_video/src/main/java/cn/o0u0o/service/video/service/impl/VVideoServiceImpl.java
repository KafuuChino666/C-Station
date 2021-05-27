package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.VVideo;
import cn.o0u0o.service.video.entity.VVideoStatus;
import cn.o0u0o.service.video.entity.vo.QueryForm;
import cn.o0u0o.service.video.entity.vo.TableData;
import cn.o0u0o.service.video.entity.vo.VideoInfoForm;
import cn.o0u0o.service.video.entity.vo.VideoInfoResult;
import cn.o0u0o.service.video.mapper.VVideoMapper;
import cn.o0u0o.service.video.service.VVideoService;
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
 * @author Guo Yangyang; Caleb Chen
 * @since 2021-05-26
 */
@Service
public class VVideoServiceImpl extends ServiceImpl<VVideoMapper, VVideo> implements VVideoService {

    @Autowired
    private VVideoMapper vVideoMapper;

    @Override
    public IPage<TableData> selectVideoByTerm(Integer page, Integer limit, Integer videoId, String videoTitle, Integer authorId, Date startTime, Date endTime, String playNub, Integer videoStatus) {
        Page<QueryForm> pageParam = new Page<>(page, limit);
        return vVideoMapper.selectVideoByTerm(pageParam, videoId, videoTitle, authorId, startTime, endTime, playNub, videoStatus);
    }

    @Override
    public VideoInfoResult getVideoInfoById(Integer videoId) {
        VideoInfoForm videoInfoById = vVideoMapper.getVideoInfoById(videoId);

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
        String videoLocation = videoInfoById.getVideoLocation();

        VideoInfoResult videoInfoResult
                = new VideoInfoResult(videoId, authorId, userName, videoTitle, videoBrief, gmtCreate, playNub, videoPnumb, videoCoin, likeNumb, zoneType, videoStatus, videoLocation);

        return videoInfoResult;
    }

    @Override
    public List<VVideoStatus> selectAllVideoStatus() {
        List<VVideoStatus> statusList = vVideoMapper.selectAllVideoStatus();
        return statusList;
    }

}
