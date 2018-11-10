package com.jba.mongodb;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.math.stat.descriptive.summary.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jba.mongodb.model.Domain;
import com.jba.mongodb.service.DomainService;
import com.jba.mongodb.starter.MongoDBStarter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoDBStarter.class)
public class DomainServiceTest {

	@Autowired
	private DomainService domainService;

	@Test
	public void testSave() {

		Domain domain = new Domain();
		domain.setDisplayAds(true);
		domain.setDomain("https://jude.com/image");
		Domain testDomain = domainService.save(domain);
		assertNotNull(testDomain);
	}
}
