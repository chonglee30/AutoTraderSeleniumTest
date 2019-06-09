package com.autotrader.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoTypeCheckbox {

	private WebDriver driver;

	private final By CHECKBOX_NEW = By.id("rfNew");
	private final By CHECKBOX_USED = By.id("rfUsed");
	private final By CHECKBOX_PREOWNED = By.id("rfPreOwned");	
	
	public AutoTypeCheckbox(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getNewCheckbox() {
		WebElement chkboxNewElement = driver.findElement(CHECKBOX_NEW);
		return chkboxNewElement;
	}
		
	public WebElement getUsedCheckbox() {
		WebElement chkboxUsedElement = driver.findElement(CHECKBOX_USED);
		return chkboxUsedElement;
	}
	
	public WebElement getPreOwnedCheckbox() {
		WebElement chkboxPreOwnedElement = driver.findElement(CHECKBOX_PREOWNED);
		return chkboxPreOwnedElement;
	}
}