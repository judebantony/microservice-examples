/**
 * 
 */
package com.jba.neo4j.service.api;

import com.jba.neo4j.domain.User;

/**
 * @author Jude
 * @since June 3, 2017
 */
public interface IUserService {
	public User createUser(String name);

	public Iterable<User> getAllUsers();
}

