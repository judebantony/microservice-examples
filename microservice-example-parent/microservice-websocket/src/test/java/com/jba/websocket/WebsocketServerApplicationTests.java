/**
 * 
 */
package com.jba.websocket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jba.websocket.starter.WebsocketServerApplication;

/**
 * @author Jude
 * @since Sep 13, 2017
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebsocketServerApplication.class)
@WebAppConfiguration
@TestPropertySource(properties = "sample.zipkin.enabled=false")
public class WebsocketServerApplicationTests {
	@Test
	public void contextLoads() {
	}
}
