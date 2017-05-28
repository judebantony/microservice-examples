/**
 * 
 */
package com.jba.config.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author Jude
 * @since May 28, 2017
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
@EnableHystrix
public class ConfigServerApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigServerApplication.class);
	public static void main(String[] args) {
		LOGGER.info("Config Server is Starting");
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
