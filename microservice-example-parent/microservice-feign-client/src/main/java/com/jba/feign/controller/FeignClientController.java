/**
 * 
 */
package com.jba.feign.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jba.feign.api.ZipkinTest;

/**
 * @author Jude
 * @since Sep 13, 2017
 */
public class FeignClientController {
	@Autowired
	private ZipkinTest zipkinTest;
	private final Random random = new Random();

	@RequestMapping("/")
	public String zipkinTest() throws InterruptedException {
		Thread.sleep(this.random.nextInt(1000));
		String s = this.zipkinTest.test();
		return "hi test/" + s;
	}

	@RequestMapping("/call")
	public String traced() {
		String s = this.zipkinTest.call();
		return "call/" + s;
	}

}
