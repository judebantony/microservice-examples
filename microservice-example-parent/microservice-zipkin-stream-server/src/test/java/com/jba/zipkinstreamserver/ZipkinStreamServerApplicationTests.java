/**
 * 
 */
package com.jba.zipkinstreamserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.jba.zipkinstreamserver.starter.ZipkinStreamServerApplication;

/**
 * @author Jude
 * @since Sep 13, 2017
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZipkinStreamServerApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT, properties = {
		"spring.datasource.initialize=true" })
@ActiveProfiles("test")
public class ZipkinStreamServerApplicationTests {
	@Test
	public void contextLoads() {
	}
}
