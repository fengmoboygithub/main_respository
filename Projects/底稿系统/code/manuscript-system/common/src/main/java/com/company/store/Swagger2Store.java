package com.company.store;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 定义Swagger2接口文档配置
 * Created by yangyc on 2019/01/15.
 */
@EnableSwagger2
public class Swagger2Store {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.company"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //.title("Spring Boot中使用Swagger2构建RESTful APIs")
                .title("投行底稿RESTful APIs")
                .description("©2020 Copyright. Powered By portal-system.")
                .version("1.0")
                .build();
    }
}
