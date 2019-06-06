package com.autotrader.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoTypeCheckbox {

	private WebDriver driver;

	private final By CHECKBOX_NEW = By.id("rfNew");
	private final By CHECKBOX_USED = By.id("rfUsed");
	private final By CHECKBOX_PREOWNED = By.id("rfPreOwned");
	
	/*@FindBy(id="rfNew")
	private WebElement chkboxNew;
	private String chkNew;
	
	@FindBy(id="rfUsed")
	private WebElement chkboxUsed;
	private String chkUsed;
	
	@FindBy(id="rfPreOwned")
	private WebElement chkboxPreOwned;
	private String chkPreOwned;*/ 
	
	
	public AutoTypeCheckbox(WebDriver driver) {
		this.driver = driver;
	}
	
	public void unselectCheckbox(WebElement checkbox) {	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		if (checkbox.isSelected()) {
			System.out.println("Unselect the checkbox");
			js.executeScript("arguments[0].click();", checkbox);
		}
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