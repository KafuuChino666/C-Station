package cn.o0u0o.service.video.service.impl;

import cn.o0u0o.service.video.entity.vo.VideoUploadAuth;
import cn.o0u0o.service.video.service.MediaService;
import cn.o0u0o.service.video.util.AliyunVodSDKUtils;
import cn.o0u0o.service.video.util.VodProperties;
import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyun.vod20170321.Client;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.utils.StringUtils;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class MediaServiceImpl implements MediaService {

    @Autowired
    private VodProperties vodProperties;

    @Override
    public String getPlayAuth(String videoSourceId) throws ClientException {
        //初始化client对象
        DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(vodProperties.getKeyid(), vodProperties.getKeysecret());

        //创建VideoPlayAuth请求对象
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest ();
        request.setVideoId(videoSourceId);

        //获取响应
        GetVideoPlayAuthResponse response = client.getAcsResponse(request);

        return response.getPlayAuth();
    }

    @Override
    public String uploadVideo(InputStream file, String originalFilename) {
        String title = originalFilename.substring(0, originalFilename.lastIndexOf("."));

        UploadStreamRequest request = new UploadStreamRequest(vodProperties.getKeyid(), vodProperties.getKeysecret(), title, originalFilename, file);
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);
        request.setApiRegionId("cn-shanghai");

        String videoId = response.getVideoId();
        //没有正确的返回videoid则说明上传失败
        if(StringUtils.isEmpty(videoId)){
            log.error("阿里云上传失败：" + response.getCode() + " - " + response.getMessage());
            // throw new Exception(ResultCodeEnum.VIDEO_UPLOAD_ALIYUN_ERROR);
        }
        return videoId;
    }

    @Override
    public VideoUploadAuth getUploadAuth(String uuid) {

        DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(vodProperties.getKeyid(), vodProperties.getKeysecret());

        CreateUploadVideoRequest request = new CreateUploadVideoRequest();
        request.setTitle(uuid + "/" + new Date()); // title = uuid + 日期
        request.setFileName(UUID.randomUUID() + ".mp4");

        try {
            CreateUploadVideoResponse clientAcsResponse = client.getAcsResponse(request);
            if (clientAcsResponse != null) {
                return new VideoUploadAuth(clientAcsResponse.getVideoId(), clientAcsResponse.getUploadAddress(), clientAcsResponse.getUploadAuth());
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public com.aliyun.vod20170321.models.GetVideoInfoResponse getVideoCove(String videoId) {
        Client client = null;
        try {
            client = AliyunVodSDKUtils.createvod20170321Client(vodProperties.getKeyid(), vodProperties.getKeysecret());
            com.aliyun.vod20170321.models.GetVideoInfoRequest getVideoInfoRequest = new com.aliyun.vod20170321.models.GetVideoInfoRequest();
            getVideoInfoRequest.setVideoId(videoId);
            com.aliyun.vod20170321.models.GetVideoInfoResponse videoInfo = client.getVideoInfo(getVideoInfoRequest);
            return client.getVideoInfo(getVideoInfoRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
