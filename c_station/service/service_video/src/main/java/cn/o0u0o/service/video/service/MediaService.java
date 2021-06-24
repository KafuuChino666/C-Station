package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.vo.VideoUploadAuth;
import com.aliyun.vod20170321.models.GetVideoInfoResponse;
import com.aliyun.vod20170321.models.ListSnapshotsResponse;
import com.aliyuncs.exceptions.ClientException;

import java.io.InputStream;

public interface MediaService {
    String getPlayAuth(String videoSourceId) throws ClientException, ClientException;

    String uploadVideo(InputStream inputStream, String originalFilename);

    VideoUploadAuth getUploadAuth(String uuid) throws ClientException;

    GetVideoInfoResponse getVideoCove(String videoId);

    ListSnapshotsResponse spriteOriginSnapshot(Integer pageSize, Integer pageNo, String videoId);
}
