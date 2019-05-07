package com.mycompany.desafio.api.base.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enabled}")
    private boolean swaggerEnabled;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.mycompany.desafio.api.controllers"))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo()).enable(swaggerEnabled);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Desafio API")
                .description("Desafio API endpoints.").version("1.0")
                .build();
    }
}
