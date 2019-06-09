package com.autotrader.pojo;

public class Automobile {

	private String maker;
	private String model;
	private String maxPrice;
	private String type;
	private Location location;
	
	public Automobile(String maker, String model, String maxPrice, String type, Location location) {
		this.maker = maker;
		this.model = model;
		this.maxPrice = maxPrice;
		this.type = type;
		this.location = location;
	}
			
	public AutoType getType() {
		switch(type) {
			case "Default":
				return AutoType.DEFAULT;
			case "New":
				return AutoType.NEW;
			case "Used":
				return AutoType.USED;
			case "Pre-Owned":
				return AutoType.PREOWNED;
			default:
				return AutoType.DEFAULT;
		}
	}
	
	public String getAutoType() {
		return this.type;
	}
	
	public String getMaker() {
		return this.maker;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getMaxPrice() {
		return this.maxPrice;
	}
	
	public Location getLocation() {
		return this.location;
	}
}