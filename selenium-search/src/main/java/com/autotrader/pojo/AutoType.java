package com.autotrader.pojo;

public enum AutoType {
	DEFAULT("New & Used"),
	NEW("New"),
	USED("Used"),
	PREOWNED("Used");
	
	private String typeValue;
	
	private AutoType(String typeValue) {
		this.typeValue = typeValue;
	}
	
	public String getAutoType() {
		return this.typeValue;
	}
}
