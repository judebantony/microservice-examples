/**
 * 
 */
package com.jba.neo4j.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jba.neo4j.constant.Neo4jConstants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jude
 * @since June 11, 2017
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.jba.neo4j.controllers")
public class SwaggerConfig {

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jba.neo4j.controllers"))
				.paths(PathSelectors.ant(Neo4jConstants.DEFAULT_INCLUDE_PATTERNS)).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("MicroService Example APIs").description("The APIs are for Example services")
				.termsOfServiceUrl("http://opensource.org/licenses/MIT").license("Apache License Version 2.0")
				.licenseUrl("http://opensource.org/licenses/MIT").version("2.0").build();
	}

}
