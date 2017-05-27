package com.jba.registry.starter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RegistrationServerApplicationTest {
	private static final String HOSTNAME = "http://localhost:";
	private static final String URI = "/eureka/apps";
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void shouldStartEurekaServer() {
		StringBuilder tempUrl = new StringBuilder().append(HOSTNAME).append(this.port).append(URI);
		ResponseEntity<String> entity = this.testRestTemplate.getForEntity(tempUrl.toString(), String.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}