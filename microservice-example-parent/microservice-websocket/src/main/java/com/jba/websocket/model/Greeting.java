/**
 * 
 */
package com.jba.websocket.model;

/**
 * @author Jude
 * @since Sep 13, 2017
 */
public class Greeting {
	private String content;

	public Greeting(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}
}