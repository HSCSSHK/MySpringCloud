package com.hsc.gateway.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2//开启swagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        //配置swagger 生成API的扫描范围
        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))
//                .build()
//                .apiInfo(apiInfo())
//                .globalOperationParameters(setHeaderToken());

        /////
//                       .select()
////                .apis(RequestHandlerSelectors.basePackage("com.zoo.lion.modules"))
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//只生成被Api这个注解注解过的类接口
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//只生成被ApiOperation这个注解注解过的api接口
//                .paths(PathSelectors.any())
//                .build()
//                .globalOperationParameters(setHeaderToken());

        ///////////
//                .apiInfo(apiInfo())
//                .select()
//                //加了ApiOperation注解的类，才生成接口文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                //包下的类，才生成接口文档
//                //.apis(RequestHandlerSelectors.basePackage("io.sysssc.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .securitySchemes(security());         //主要关注点--统一填写一次token


//                        .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))
//                .build()
//                .apiInfo(apiInfo())
//                .securitySchemes(security())
//                .securityContexts(securityContexts());

//                .select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .apis(RequestHandlerSelectors.any())
//                .paths(regex("^.*(?<!error)$"))
//                .build()
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts());


                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());

    }
    /**
     * 创建api文档信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("微服务springcloud v1.2")
                .description("微服务接口springcloud")
                .termsOfServiceUrl("https://github.com/HSCSSHK/MySpringCloud")
                .version("1.0")
                .build();
    }

    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("X-Auth-Token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }
    private List<ApiKey> security() {
//        return new ArrayList(
//                new ApiKey("token", "token", "header")
//        );
        List<ApiKey> apiKeyList= new ArrayList<ApiKey>();
        apiKeyList.add(new ApiKey("token", "token", "header"));
        return apiKeyList;

    }

    private List<ApiKey> securitySchemes() {
//        List<ApiKey> apiKeyList= new ArrayList();
//        apiKeyList.add(new ApiKey("x-auth-token", "x-auth-token", "header"));
//        return apiKeyList;

        List<ApiKey> apiKeyList= new ArrayList<ApiKey>();
        apiKeyList.add(new ApiKey("token", "token", "header"));
        return apiKeyList;

    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts=new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(regex("^(?!auth).*$"))
                        .build());
        return securityContexts;
    }
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences=new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }
}
