package com.autotrader.pages.components;

import com.autotrader.pages.components.AutoTypeCheckbox;
import com.autotrader.pages.BasePage;
import com.autotrader.pages.ResultPage;
import com.autotrader.wait.SelectWait;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BasicAutoSearchTab extends BasePage {
	private WebDriver driver;

	AutoTypeCheckbox autoTypeCheckbox;
	AutoMakeModelLists autoMakeModelLists;
	
	@FindBy(id="rfPriceHigh")
	private WebElement selectMaxPrice;
	
	@FindBy(id="locationAddress")
	private WebElement inputLocation;
	private String location;
	
	@FindBy(id="SearchButton")
	private WebElement btnSearch;
	
	@FindBy(id="rfNew")
	private WebElement chkboxNew;
	private String chkNew;
	
	@FindBy(id="rfUsed")
	private WebElement chkboxUsed;
	private String chkUsed;
	
	@FindBy(id="rfPreOwned")
	private WebElement chkboxPreOwned;
	private String chkPreOwned;
	
	public WebElement getNewCheckbox() {
		return chkboxNew;
	}
	
	public WebElement getUsedCheckbox() {
		return chkboxUsed;
	}

	public WebElement getPreOwnedCheckbox() {
		return chkboxPreOwned;
	}

	public void unselectCheckbox(WebElement checkbox) {	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		if (checkbox.isSelected()) {
			System.out.println("Unselect the checkbox");
			js.executeScript("arguments[0].click();", checkbox);
		}
	}
	
	public BasicAutoSearchTab(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.autoTypeCheckbox = new AutoTypeCheckbox(driver);
		this.autoMakeModelLists = new AutoMakeModelLists(driver);
	}
	
	public AutoTypeCheckbox getAutoTypeCheckbox() {
		return autoTypeCheckbox;
	}
	
	public AutoMakeModelLists getAutoMakeModelLists() {
		return autoMakeModelLists;
	}
	
	public void selectPrice(String autoPrice) {
		Select price = new Select(selectMaxPrice);
		price.selectByValue(autoPrice);		
		SelectWait.using(driver).waitForSelectedElement(price);
	}
	
	public void enterLocationAddress(String autoLocation) {
		location = autoLocation;
		type(inputLocation, autoLocation);
		System.out.println("Text Input: "+getInputValue(inputLocation));
	}
	
	public void clickSearchButton() {
		click(btnSearch);
	}	
}