package cn.o0u0o.service.video.service;

import com.aliyuncs.exceptions.ClientException;

public interface MediaService {
    String getPlayAuth(String videoSourceId) throws ClientException, ClientException;
}
