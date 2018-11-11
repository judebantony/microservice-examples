/**
 * 
 */
package com.jba.neo4j.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jba.neo4j.domain.User;
import com.jba.neo4j.service.impl.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Jude
 * @since June 3, 2017
 */

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "users")
@EnableDiscoveryClient
@RefreshScope
public class UserController {
	private static final String HEALTH = "User Repo Service is up and running!";
	@Autowired
	private UserService userService;

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "users", notes = "This api will retun the user info!")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@HystrixCommand(fallbackMethod = "defaultUserService")
	public Iterable<User> user() {
		return userService.getAllUsers();
	}

	public String defaultUserService() {
		return "User Neo4j Repo Service has some issue now , please try after some time!";
	}

	/**
	 * Load user
	 * 
	 * @param userName
	 * @return
	 */
	@PostMapping(value = "/load/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public User loadUser(@PathVariable String userName) {
		return userService.createUser(userName);
	}

	@GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public String health() {
		return HEALTH;
	}

}
