/**
 * 
 */
package com.jba.camunda.bpm.starter;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Jude
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.jba.camunda.bpm" })
@EnableProcessApplication("camundaBPMStarter")
public class CamundaBPMStarter {
	public boolean processApplicationStopped;

	public static void main(final String... args) throws Exception {
		SpringApplication.run(CamundaBPMStarter.class, args);
	}


}