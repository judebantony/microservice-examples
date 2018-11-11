package com.jba.cassandra.starter;

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
public class CassandraStarter {
	public static void main(String args[]) {
		SpringApplication.run(CassandraStarter.class, args);
	}

}