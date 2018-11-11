/**
 * 
 */
package com.jba.gateway.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Jude
 * @since June 04, 2017
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@ComponentScan("com.jba")
@EnableHystrix
public class ApiGatewayApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiGatewayApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Api Gateway Server is Starting");
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
