package cn.o0u0o.service.video.service;

import cn.o0u0o.service.video.entity.vo.VideoUploadAuth;
import com.aliyuncs.exceptions.ClientException;

import java.io.InputStream;

public interface MediaService {
    String getPlayAuth(String videoSourceId) throws ClientException, ClientException;

    String uploadVideo(InputStream inputStream, String originalFilename);

    VideoUploadAuth getUploadAuth(String uuid) throws ClientException;
}
