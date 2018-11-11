/**
 * 
 */
package com.jba.neo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.jba.neo4j.domain.User;

/**
 * @author Jude
 * @since June 3, 2017
 */
@Repository
public interface UserRepository extends Neo4jRepository<User,Long> {

}
