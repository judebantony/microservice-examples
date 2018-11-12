/**
 * 
 */
package com.jba.feign.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jude
 * @since Sep 13, 2017
 */
@FeignClient("zipkinTest")
@RibbonClient(name = "zipkinTest")
public interface ZipkinTest {
	@RequestMapping(value = "/call", method = RequestMethod.GET)
	String call();

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	String test();
}