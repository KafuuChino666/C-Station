package cn.o0u0o.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("GuoYangYang")
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.o0u0o.service"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    Docket docketChen() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfoChen())
                .groupName("Caleb_Chen")
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    //配置Swagger信息
    private ApiInfo apiInfoChen() {
        Contact contact = new Contact("陈芊浩", "https//o0u0o.cn/", "690209522@qq.com");

        return new ApiInfo("陈芊浩Swagger",
                "加油！",
                "1.0",
                "https//o0u0o.cn/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
