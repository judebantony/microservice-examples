/**
 * 
 */
package com.jba.neo4j.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jba.neo4j.constant.Neo4jConstants;

/**
 * @author Jude
 * @since Jan 10, 2017
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/doc/v2/api-docs", "/v2/api-docs");
		registry.addRedirectViewController("/doc/configuration/ui", "/configuration/ui");
		registry.addRedirectViewController("/doc/configuration/security", "/configuration/security");
		registry.addRedirectViewController("/doc/swagger-resources", "/swagger-resources");
		registry.addRedirectViewController("/doc", "/doc/swagger-ui.html");
		registry.addRedirectViewController("/doc/", "/doc/swagger-ui.html");
		registry.addRedirectViewController("/doc/swagger-resources/configuration/ui",
				"/swagger-resources/configuration/ui");
		registry.addRedirectViewController("/doc/swagger-resources/configuration/security",
				"/swagger-resources/configuration/security");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(Neo4jConstants.PREFIX);
		resolver.setSuffix(Neo4jConstants.SUFFIX);
		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/doc/**").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/doc/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/admin/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

	}

}
