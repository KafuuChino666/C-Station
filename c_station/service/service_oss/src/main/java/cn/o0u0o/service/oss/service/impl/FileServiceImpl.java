package cn.o0u0o.service.oss.service.impl;

import cn.o0u0o.service.oss.service.FileService;
import cn.o0u0o.service.oss.util.OssProperties;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private OssProperties ossProperties;

    @Override
    public String upload(InputStream inputStream, String module, String originalFilename) {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ossProperties.getEndpoint(), ossProperties.getAccessKeyId(),
                ossProperties.getAccessKeySecret());
        if (!ossClient.doesBucketExist(ossProperties.getBucketname())) {
            ossClient.createBucket(ossProperties.getBucketname());
            ossClient.setBucketAcl(ossProperties.getBucketname(), CannedAccessControlList.PublicRead);
        }

        //构建文件路径
        String timePath = new DateTime().toString("yyyy/MM/dd");
        String objectName = module + "/" + timePath + "/" +
                UUID.randomUUID().toString() + "." + originalFilename.substring(originalFilename.lastIndexOf("."));
        ossClient.putObject(ossProperties.getBucketname(), objectName, inputStream);

        //https://mcsql-file.oss-cn-beijing.aliyuncs.com/asas/centos.png
        return "https://" + ossProperties.getBucketname() + "." + ossProperties.getEndpoint() + "/" + objectName;
    }

    @Override
    public void removeFile(String url) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ossProperties.getEndpoint(), ossProperties.getAccessKeyId(),
                ossProperties.getAccessKeySecret());

        String hostUrl = "https://" + ossProperties.getBucketname() + "." + ossProperties.getEndpoint()+ "/";
        String objectName = url.substring(hostUrl.length());

        ossClient.deleteObject(ossProperties.getBucketname(), objectName);

        ossClient.shutdown();
    }
}
