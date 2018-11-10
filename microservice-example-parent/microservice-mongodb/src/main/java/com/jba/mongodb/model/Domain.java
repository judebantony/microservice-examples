package com.jba.mongodb.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "domain")
public class Domain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7652942853932764901L;
	@Id
	private long id;
	@Indexed(unique = true)
	private String domain;
	private boolean displayAds;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public boolean isDisplayAds() {
		return displayAds;
	}
	public void setDisplayAds(boolean displayAds) {
		this.displayAds = displayAds;
	}
	
	
}
