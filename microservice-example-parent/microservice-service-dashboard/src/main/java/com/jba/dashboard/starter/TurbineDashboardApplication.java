/**
 * 
 */
package com.jba.dashboard.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author Jude
 * @since May 27, 2017
 */
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableTurbine
@SpringBootApplication
public class TurbineDashboardApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(TurbineDashboardApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Dashboard Server is Starting");
		SpringApplication.run(TurbineDashboardApplication.class, args);
	}
}
