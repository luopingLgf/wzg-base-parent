package com.wzg.framework.knife4j;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * @since 2020/09/18 11:04
 * @since knife4j-spring-boot2-demo 1.0
 */
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class Knife4jConfig {
    @Value("${spring.application.name:xx-xxx-service}")
    private String appName;
    @Value("${server.servlet.context-path:xxx}")
    private String contextPath;
    private static final String BASE_PACKAGE = "com.wzg";

    @Bean(value = "defaultApi1")
    public Docket defaultApi1() {
        List<SecurityScheme> securitySchemes = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;

        List<SecurityContext> securityContexts = Arrays.asList(SecurityContext.builder()
                .securityReferences(CollectionUtil.newArrayList(new SecurityReference("Authorization", authorizationScopes)))
                // .forPaths(PathSelectors.regex("/.*"))
                .build());
        HttpAuthenticationScheme httpAuthenticationScheme = HttpAuthenticationScheme.JWT_BEARER_BUILDER
                .name(HttpHeaders.AUTHORIZATION)
                .description("Bearer Token")
                .build();
        securitySchemes.add(httpAuthenticationScheme);

        // ??????????????????
        List<RequestParameter> requestParameters = new ArrayList<>();
        requestParameters.add(new RequestParameterBuilder().name("test").description("??????").in(ParameterType.QUERY).required(true).build());

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                //????????????
                .groupName("????????????")
                .select()
                //????????????Controller???????????????
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                //.globalRequestParameters(requestParameters)
                //.extensions(openApiExtensionResolver.buildExtensions("1.2.x"))
                //.extensions(openApiExtensionResolver.buildSettingExtensions())
                .securityContexts(securityContexts)
                .securitySchemes(securitySchemes);
    }

    /**
     * @return Docket
     */
    public Docket defaultApi2() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                //????????????
                .groupName("2.????????????2")
                .select()
                //????????????Controller???????????????
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @return Docket
     */
    public Docket defaultApi3() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                // ????????????
                .groupName("3.????????????3")
                .select()
                //????????????Controller???????????????
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(appName + " Knife4j??????~~~?????????")
                .description(contextPath + " Knife4j RESTFUL APIs")
                .termsOfServiceUrl("https://www.xiaoymin.com/")
                .contact(new Contact(BASE_PACKAGE, "https://gitee.com/xiaoymin", "xiaoymin@foxmail.com"))
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }

    private ApiKey apiKey1() {
        return new ApiKey("BearerToken1", "Authorization-x", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                // .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    private SecurityContext securityContext1() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth1())
                // .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return CollectionUtil.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }

    List<SecurityReference> defaultAuth1() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return CollectionUtil.newArrayList(new SecurityReference("BearerToken1", authorizationScopes));
    }
}
