package com.codewithashu.user.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket apiDoc() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo())

				.select().apis(RequestHandlerSelectors.basePackage("com.codewithashu.user")).paths(PathSelectors.any())
				.build();
	}

//	@SuppressWarnings("deprecation")
//	private ApiInfo getInfo() {
//
//		return new ApiInfo("Ashwini Swagger", "This project is devloped by HAPPYTECH SOFTWARE SOLUTIONS PVT LTD,HINJEWADI(PUNE)", "version 1.0", "pune",
//				 "patilashwini566@gmail.com", "NextPage Name");
//	}
	
	
	@SuppressWarnings("deprecation")
	private ApiInfo getInfo() {

		return new ApiInfo("HAPPYTECH SOFTWARE SOLUTIONS PVT LTD,THERGOAN(PUNE)",
				"This project is concept by MISS.Ashwini Patil(Junior JAVA Backend Devloper)", "version 1.0", "Pune",
				"AMIDA IT Team", "Call & Whatsapp +919975260649 / email : patilashwini566@gmail.com",
				"NextPage Name");
	}



}
