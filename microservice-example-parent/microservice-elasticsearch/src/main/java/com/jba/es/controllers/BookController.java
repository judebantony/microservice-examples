/**
 * 
 */
package com.jba.es.controllers;

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

import com.jba.es.model.Book;
import com.jba.es.service.BookService;
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
@Api(value = "books")
@EnableDiscoveryClient
@RefreshScope
public class BookController {
	private static final String HEALTH = "Book ES Repo Service is up and running!";
	@Autowired
	private BookService bookService;

	@GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "books", notes = "This api will retun the books info!")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@HystrixCommand(fallbackMethod = "defaultBooksService")
	public Iterable<Book> books() {
		return bookService.findAll();
	}

	public String defaultBooksService() {
		return "Book ElasticSearch Repo Service has some issue now , please try after some time!";
	}

	@GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public String health() {
		return HEALTH;
	}

}
