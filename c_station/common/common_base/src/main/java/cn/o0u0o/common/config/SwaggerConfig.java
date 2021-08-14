package cn.o0u0o.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    private ApiInfo apiInfo(String name, String description, String version) {
        return new ApiInfoBuilder().title(name).description(description).version(version).build();
    }

    @Bean
    public Docket web_api_admin_acl() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("acl-api", "权限管理系统", "1.0"))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/admin/acl/**"))
                .build()
                .groupName("权限管理系统:web-admin-接口文档V1.0")
                .pathMapping("/");
    }

    @Bean
    public Docket web_api_acl() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("acl-api", "验证码相关api", "1.0"))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/acl/**"))
                .build()
                .groupName("验证码相关api:web-admin-接口文档V1.0")
                .pathMapping("/");
    }

    @Bean
    public Docket web_api_userAdmin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("admin-api", "用户管理相关api", "1.0"))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/views/**"))
                .build()
                .groupName("用户管理相关api:web-admin-接口文档V1.0")
                .pathMapping("/");
    }

    @Bean
    public Docket web_api_video() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("video-api", "视频服务api", "1.0"))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/video/**"))
                .build()
                .groupName("视频服务api:web-video-接口文档V1.0")
                .pathMapping("/");
    }
}
