package com.autotrader.pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.autotrader.wait.DynamicWait;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//this is an improper use of a base page
//the base page should not be a collection of methods that you need
//it should instead implement methods that are applicable to pages
//you can see this in my book, Selenium Tips and Tricks
public class BasePage {
	
	protected WebDriver driver;
	protected JavascriptExecutor js;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
		
	public void unselectCheckboxJS(WebElement element) {	
		if (element.isSelected()) {
			clickJS(element);
		}
	}
	
	public void unselectCheckbox(WebElement element) {	
		if (element.isSelected()) {
			click(element);
		}
	}
	
	public void clickJS(WebElement element) {
		js.executeScript("arguments[0].click();", element);
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
