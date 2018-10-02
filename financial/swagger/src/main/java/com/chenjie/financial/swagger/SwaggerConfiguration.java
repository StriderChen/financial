package com.chenjie.financial.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author chenjie
 * @Date 2018/9/28 17:04
 * @Description:
 */
@Configuration
@ComponentScan(basePackages = "com.chenjie.financial.swagger")
//@EnableSwagger2
public class SwaggerConfiguration {

    @Autowired
    private SwaggerInfo swaggerInfo;

    @Bean
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName(swaggerInfo.getGroupName());
        ApiSelectorBuilder builder = docket.select();
        if(!StringUtils.isEmpty(swaggerInfo.getBasePackage())){
            builder = builder.apis(RequestHandlerSelectors.basePackage(swaggerInfo.getBasePackage()));
        }
        if(!StringUtils.isEmpty(swaggerInfo.getAntPath())){
            builder = builder.paths(PathSelectors.ant(swaggerInfo.getAntPath()));
        }

        return builder.build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title(swaggerInfo.getTitle())
                //描述
                .description(swaggerInfo.getDescription())
                //.termsOfServiceUrl("http://springfox.io")
                //创建人
                //.contact(new Contact("陈杰", "http://www.baidu.com", "729217667@qq.com"))
                //版本号
                .version("1.0")
                //license
                .license(swaggerInfo.getLicense())
                .build();
    }
}
