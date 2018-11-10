package com.jba.cassandra.repository;
/**
 * @author Jude
 */
import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jba.cassandra.model.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

	@Query("Select * from products where name=?0")
    List<Product> findByProductName(String name);

}