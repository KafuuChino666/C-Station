package cn.o0u0o;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 */
@SpringBootApplication
@MapperScan({"cn.o0u0o.service.security.mapper", "cn.o0u0o.service.video.mapper", "cn.o0u0o.service.admin.mapper"})
public class CStationApplication {
    public static void main(String[] args) {
        SpringApplication.run(CStationApplication.class, args);
    }
}
