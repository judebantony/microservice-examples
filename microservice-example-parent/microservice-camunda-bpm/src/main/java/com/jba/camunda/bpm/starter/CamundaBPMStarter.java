/**
 * 
 */
package com.jba.camunda.bpm.starter;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jude
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.jba.camunda.bpm" })
@EnableProcessApplication("camundaBPMStarter")
@EnableDiscoveryClient
@EnableSwagger2
@EnableCircuitBreaker
@EnableHystrix
public class CamundaBPMStarter {
	private static final Logger LOGGER = LoggerFactory.getLogger(CamundaBPMStarter.class);
	public static void main(final String... args) throws Exception {
		LOGGER.info("Camunda BPM Server is Starting");
		SpringApplication.run(CamundaBPMStarter.class, args);
	}


}