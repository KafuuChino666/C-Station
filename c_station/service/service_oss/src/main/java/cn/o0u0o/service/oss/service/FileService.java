package cn.o0u0o.service.oss.service;

import java.io.InputStream;

public interface FileService {
    /**
     * 阿里云文件上传
     * @param inputStream 文件流
     * @param module 文件夹名
     * @param originalFilename 文件原名称
     * @return oss文件url路径
     */
    String upload(InputStream inputStream, String module, String originalFilename);

    /**
     * 删除文件
     * @param url 文件外链url
     */
    void removeFile(String url);
}
