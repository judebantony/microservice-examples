package com.jba.mongodb.service;

import com.jba.mongodb.model.Domain;

public interface DomainService {

	Domain save(Domain book);

	void delete(Domain book);

	Iterable<Domain> findAll();

	Domain findFirstByDomain(String domain);

}