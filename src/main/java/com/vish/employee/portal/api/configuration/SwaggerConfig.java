package com.vish.employee.portal.api.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.vish.employee.portal.api.controller"))
				.paths(PathSelectors.regex("/api/v1/employees/*"))
				.build()
				.apiInfo(apiInformation());
	}

	private ApiInfo apiInformation() {
		return new ApiInfo("Employee Portal",
				"Employee portal backend APIs", 
				"API TOS", "Terms of Service", 
				new Contact("Vishnu Chaturvedi", "https://github.com/vchaturv-ios", "vishnu.chaturvedi.1002@gmail.com"), 
				"License of API", "API License URL", Collections.emptyList());
	}

}
