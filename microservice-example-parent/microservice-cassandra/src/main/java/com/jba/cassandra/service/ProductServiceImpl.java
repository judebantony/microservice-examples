package com.jba.cassandra.service;
/**
 * @author Jude
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jba.cassandra.model.Product;
import com.jba.cassandra.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
    private ProductRepository productRepository;


    public Product save(Product book) {
        return productRepository.save(book);
    }

    public void delete(Product book) {
        productRepository.delete(book);
    }

    public Product findOne(String id) {
        return productRepository.findOne(id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }


    public List<Product> findByProductName(String name) {
        return productRepository.findByProductName(name);
    }

}