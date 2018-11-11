/**
 * 
 */
package com.jba.feign.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Jude
 * @since Sep 13, 2017
 */
@EnableDiscoveryClient
@EnableHystrixDashboard
@SpringBootApplication
@EnableFeignClients
public class FeignClientApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Feign Client is Starting");
		SpringApplication.run(FeignClientApplication.class, args);
	}

}
