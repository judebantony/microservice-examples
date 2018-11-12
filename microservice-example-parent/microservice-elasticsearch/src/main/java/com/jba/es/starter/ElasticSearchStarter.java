package com.jba.es.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCircuitBreaker
@EnableDiscoveryClient
@ComponentScan("com.jba")
@EnableHystrix
public class ElasticSearchStarter {
	private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchStarter.class);

	public static void main(String args[]) {
		LOGGER.info("ElasticSearch Server is Starting");
		SpringApplication.run(ElasticSearchStarter.class, args);
	}

}