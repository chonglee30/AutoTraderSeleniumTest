package com.autotrader.pojo;

public class Location {

	private String postalCode;		
	private String city;
	
	public Location(String postolCode, String city) {
		this.postalCode = postolCode;
		this.city = city;
	}
	
	public String getPostalCode() {
		return this.postalCode;
	}
	
	public String getCity() {
		return this.city;
	}
	
}
