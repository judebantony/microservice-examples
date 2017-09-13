/**
 * 
 */
package com.jba.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import com.jba.websocket.model.Greeting;
import com.jba.websocket.model.Message;

/**
 * @author Jude
 * @since Sep 13, 2017
 */
public class WebsocketController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebsocketController.class);

	@MessageMapping("/message")
	@SendTo("/topic/greetings")
	public Greeting greeting(Message message) throws Exception {
		LOGGER.info("Hello: " + message);
		Thread.sleep(3000); // simulated delay
		// Then send back greeting
		return new Greeting("Hello, " + message.getName() + "!");
	}
}
