/**
 * 
 */
package com.jba.zipkinstreamserver.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * @author Jude
 * @since Sep 13, 2017
 */

@EnableDiscoveryClient
@EnableHystrixDashboard
@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinStreamServerApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ZipkinStreamServerApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Zipkin Stream Server is Starting");
		SpringApplication.run(ZipkinStreamServerApplication.class, args);
	}
}
