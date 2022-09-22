package com.efunzo.services.epellation.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	public Docket documentation() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(
						new ApiInfoBuilder()
						.description("Epellation Api documentation")
						.title("Epellation Rest Api")
						.build()
					)
				.groupName("REST API V1")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.efunzo.services.epellation"))
				.paths(PathSelectors.ant("/**"))
				.build();
	}

}
