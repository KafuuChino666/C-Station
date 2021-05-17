package cn.o0u0o.service.video.entity.vo;

import lombok.Data;

/**
 * 阿里云VOD上传凭证
 */
@Data
public class VideoUploadAuth {

    private String videoId;
    private String uploadAddress;
    private String uploadAuth;

    public VideoUploadAuth() {
    }

    public VideoUploadAuth(String videoId, String uploadAddress, String uploadAuth) {
        this.videoId = videoId;
        this.uploadAddress = uploadAddress;
        this.uploadAuth = uploadAuth;
    }
}
