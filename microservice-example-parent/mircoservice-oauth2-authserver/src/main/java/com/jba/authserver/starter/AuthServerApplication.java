/**
 * 
 */
package com.jba.authserver.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Jude
 * @since June 16, 2017
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@ComponentScan("com.jba")
@EnableHystrix
public class AuthServerApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthServerApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Auth Server Server is Starting");
		SpringApplication.run(AuthServerApplication.class, args);
	}

}
