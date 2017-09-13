/**
 * 
 */
package com.jba.websocket.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author Jude
 * @since Sep 13, 2017
 */
@EnableDiscoveryClient
@EnableHystrixDashboard
@SpringBootApplication
@EnableWebSocketMessageBroker
public class WebsocketServerApplication  extends AbstractWebSocketMessageBrokerConfigurer {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebsocketServerApplication.class);
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/message").withSockJS();
	}
	public static void main(String[] args) {
		LOGGER.info("Websocket Server is Starting");
		SpringApplication.run(WebsocketServerApplication.class, args);
	}

}
