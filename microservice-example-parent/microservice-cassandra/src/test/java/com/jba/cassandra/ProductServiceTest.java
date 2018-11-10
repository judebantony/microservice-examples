package com.jba.cassandra;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jba.cassandra.model.Product;
import com.jba.cassandra.service.ProductService;
import com.jba.cassandra.starter.CassandraStarter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CassandraStarter.class)
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testSave() {

		Product product = new Product();
		product.setImageUrl("https://jude.com/image");
		Product.ProductPrimaryKey productPrimaryKey = new Product.ProductPrimaryKey();
		productPrimaryKey.setDescription("desc");
		productPrimaryKey.setName("judeproduct");
		productPrimaryKey.setPrice(1);
		Product testProduct = productService.save(product);
		System.out.println(testProduct.toString());

	}

	@Test
	public void testFindOne() {

		Product product = new Product();
		product.setImageUrl("https://jude.com/image");
		Product.ProductPrimaryKey productPrimaryKey = new Product.ProductPrimaryKey();
		productPrimaryKey.setDescription("desc");
		productPrimaryKey.setName("judeproduct");
		productPrimaryKey.setPrice(1);
		productService.save(product);
		List<Product> testProduct = productService.findByProductName(product.getProductPrimaryKey().getName());
		assertNotNull(testProduct);

	}

}
