package com.autotrader.pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.autotrader.wait.DynamicWait;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	int WAIT_TIME = 30;
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, WAIT_TIME);
	}
	
	public void click(By locator) {
        find(locator).click();
    }

    public void click(WebElement clickElement) {
    	DynamicWait.using(driver).waitForElementToBeVisible(clickElement);
    	DynamicWait.using(driver).waitForElementToBeClickable(clickElement);
        clickElement.click();
    }
		
	public WebElement find(By locator) {
        return driver.findElement(locator);
    }
		
    public void type(By inputLocator, String text) {
    	DynamicWait.using(driver).waitForElementToBeVisible(inputLocator);
    	DynamicWait.using(driver).waitForElementToBeClickable(inputLocator);
        find(inputLocator).sendKeys(text);
    }

    public void type(WebElement inputElement, String text) {
    	DynamicWait.using(driver).waitForElementToBeVisible(inputElement);
    	DynamicWait.using(driver).waitForElementToBeClickable(inputElement);
    	inputElement.clear();
        inputElement.sendKeys(text);
    }
	
    public String getInputValue(WebElement inputElement) {
    	return inputElement.getAttribute("value");
    }
    
    public boolean isDisplayed(By locator) {
        try {
           return find(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}