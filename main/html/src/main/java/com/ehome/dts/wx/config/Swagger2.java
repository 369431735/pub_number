package com.ehome.dts.wx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
//	@Autowired
//	FinalValue value;
	@Value("${system.environment}")
	private String systemEnvironment;
	
    @Bean
    public Docket createRestApi() {
    	String pacPath = "com.ehome.web.abcdefg";
    	if("devEnvironment".equals(systemEnvironment)){
    		pacPath = "com.ehome.dts.wx.controller";
    	}
    	return new Docket(DocumentationType.SWAGGER_2)
    	.apiInfo(apiInfo())
    	.select()
    	.apis(RequestHandlerSelectors.basePackage(pacPath))
    	.paths(PathSelectors.any())
    	.build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("大头蒜微信接口")
                .description("大头蒜项目微信服务器接口文档")
                .termsOfServiceUrl("http://i-jia.net")
                .contact("xi.yang@i-jia.net")
                .version("1.0")
                .build();
    }

}