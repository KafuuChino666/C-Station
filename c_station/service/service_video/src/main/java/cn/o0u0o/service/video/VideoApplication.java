package cn.o0u0o.service.video;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Guo Yangyang
 * @version 1.0
 * @date 2021/8/15 21:31
 */

@SpringBootApplication
@ComponentScan({"cn.o0u0o"})
@MapperScan("cn.o0u0o.service.video.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class VideoApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoApplication.class, args);
    }
}
