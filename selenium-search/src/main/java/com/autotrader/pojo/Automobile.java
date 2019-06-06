package com.autotrader.pojo;

public class Automobile {

	private String maker;
	private String model;
	private String maxPrice;
	private String type;
	
	public Automobile(String maker, String model, String maxPrice, String type) {
		this.maker = maker;
		this.model = model;
		this.maxPrice = maxPrice;
		this.type = type;
	}
	
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
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
	
	public void setType(String type) {
		this.type = type;
	}	
	
}