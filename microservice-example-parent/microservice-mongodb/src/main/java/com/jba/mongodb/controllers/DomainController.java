/**
 * 
 */
package com.jba.mongodb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jba.mongodb.model.Domain;
import com.jba.mongodb.service.DomainService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Jude
 * 
 */

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "domains")
@EnableDiscoveryClient
@RefreshScope
public class DomainController {
	private static final String HEALTH = "Domains MogoDB Repo Service is up and running!";
	@Autowired
	private DomainService domainService;

	@GetMapping(value = "/domains", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "products", notes = "This api will retun the domain info!")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@HystrixCommand(fallbackMethod = "defaultDomainsService")
	public Iterable<Domain> domains() {
		return domainService.findAll();
	}

	public String defaultDomainsService() {
		return "Domains Mongo Repo Service has some issue now , please try after some time!";
	}

	@GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public String health() {
		return HEALTH;
	}

}
