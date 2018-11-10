package com.jba.mongodb.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jba.mongodb.model.Domain;
import com.jba.mongodb.repository.DomainRepository;

@Service
public class DomainServiceImpl implements DomainService {
	@Autowired
    private DomainRepository productRepository;


    public Domain save(Domain book) {
        return productRepository.save(book);
    }

    public void delete(Domain book) {
        productRepository.delete(book);
    }

    public Iterable<Domain> findAll() {
        return productRepository.findAll();
    }

    public Domain findFirstByDomain(String name) {
        return productRepository.findFirstByDomain(name);
    }

}