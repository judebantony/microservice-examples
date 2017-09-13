/**
 * 
 */
package com.jba.neo4j.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jba.neo4j.domain.User;
import com.jba.neo4j.repository.UserRepository;
import com.jba.neo4j.service.api.IUserService;

/**
 * @author Jude
 * @since June 3, 2017
 */
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(String name) {
		return userRepository.save(new User(name));
	}

	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

}
