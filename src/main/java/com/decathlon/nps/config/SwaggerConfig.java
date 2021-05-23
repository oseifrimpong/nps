package com.decathlon.nps.config;

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

/**
 * @Refrence:
 * @Author: obed osei frimpong
 * @Date: 2021/5/23
 * @Modify:
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.decathlon"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("NPS Sample project RESTFUL API")
                .description("NPS service")
                .contact(new Contact("Obed","","obed.oseifrimpong@decathlon.com"))
                .version("0.0.1")
                .build();
    }
}