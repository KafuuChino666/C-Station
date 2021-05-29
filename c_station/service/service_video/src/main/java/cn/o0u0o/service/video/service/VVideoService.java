package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.VVideo;
import cn.o0u0o.service.video.entity.VVideoStatus;
import cn.o0u0o.service.video.entity.vo.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

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
public interface VVideoService extends IService<VVideo> {

    IPage<TableData> selectVideoByTerm(Integer page, Integer limit, Integer videoId, String videoTitle, Integer authorId, Date startTime, Date endTime, String playNub, Integer videoStatus);

    VideoInfoResult getVideoInfoById(Integer id);

    List<VVideoStatus> selectAllVideoStatus();

    boolean contribute(VideoUpload video);

    String uploadCover(MultipartFile file);

    void uploadVideoSucceed(FileUploadComplete object);

    Long addOneVideo(String uuid, VideoUpload video);
}
