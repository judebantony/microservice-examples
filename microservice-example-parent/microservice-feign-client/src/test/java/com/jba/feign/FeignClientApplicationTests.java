/**
 * 
 */
package com.jba.feign;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.jba.feign.starter.FeignClientApplication;

/**
 * @author Jude
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FeignClientApplication.class)
@TestPropertySource(properties = "sample.zipkin.enabled=false")
public class FeignClientApplicationTests {
	@Test
	public void contextLoads() {
	}
}
