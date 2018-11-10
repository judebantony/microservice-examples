package com.jba.cassandra.service;
/**
 * @author Jude
 */
import java.util.List;

import com.jba.cassandra.model.Product;

public interface ProductService {

	Product save(Product book);

    void delete(Product book);

    Iterable<Product> findAll();

    List<Product> findByProductName(String name);


}