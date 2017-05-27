package com.jba.registry.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Jude
 * @since May 27, 2017
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationServerApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServerApplication.class);	
	public static void main(String[] args) throws Exception {
		LOGGER.info("TravelGo Registration Server is Starting");
		SpringApplication.run(RegistrationServerApplication.class, args);
	}
}
