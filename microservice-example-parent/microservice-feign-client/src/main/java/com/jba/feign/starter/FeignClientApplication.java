/**
 * 
 */
package com.jba.feign.starter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;

import zipkin.Span;

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
	private static final Log logger = LogFactory.getLog(FeignClientApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Feign Client is Starting");
		SpringApplication.run(FeignClientApplication.class, args);
	}

	@Bean
	@ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
	public ZipkinSpanReporter spanCollector() {
		return new ZipkinSpanReporter() {
			@Override
			public void report(Span span) {
				logger.info(span);
			}
		};
	}
}
