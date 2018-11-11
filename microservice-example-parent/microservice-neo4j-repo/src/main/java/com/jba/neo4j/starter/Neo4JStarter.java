/**
 * 
 */
package com.jba.neo4j.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jude
 * @since June 3, 2017
 */
@SpringBootApplication
@EnableSwagger2
@EnableCircuitBreaker
@EntityScan("com.jba.neo4j.domain")
@EnableDiscoveryClient
@ComponentScan("com.jba")
@EnableHystrix
public class Neo4JStarter {
	private static final Logger LOGGER = LoggerFactory.getLogger(Neo4JStarter.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.info("User Neo4j Repo Server is Starting");
		SpringApplication.run(Neo4JStarter.class, args);
	}

}
