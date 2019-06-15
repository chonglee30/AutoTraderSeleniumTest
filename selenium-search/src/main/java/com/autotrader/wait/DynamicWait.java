package com.autotrader.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

//personnaly, even if i use expected conditions and explicit waits a lot, i find this class to have very little value
//use the explicit waits in the page objects instead
public class DynamicWait {

	private static final int GLOABL_WAIT_TIME = 20;
	private WebDriver driver;
	
	public DynamicWait(WebDriver webDriver) {
		this.driver = webDriver;
	}
	
	public static DynamicWait using (WebDriver driver) {
		return new DynamicWait(driver);
	}
	
	public Boolean waitForAttributeContains(WebElement element, String attribute, String value) {
		ExpectedCondition<Boolean> condition = ExpectedConditions.attributeContains(element, attribute, value);
		return waitInternalForBoolean(condition, GLOABL_WAIT_TIME);
	}	
	
	public void waitForElementToBeClickable(By by) {
	    WebDriverWait webDriverWait = new WebDriverWait(driver, GLOABL_WAIT_TIME);
	    ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(by);
	    webDriverWait.until(condition);
    }
 
	public void waitForElementToBeClickable(WebElement element) {
	    WebDriverWait webDriverWait = new WebDriverWait(driver, GLOABL_WAIT_TIME);
	    ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(element);
	    webDriverWait.until(condition);
    }

	public void waitForElementToBeVisible(By by) {
	    WebDriverWait webDriverWait = new WebDriverWait(driver, GLOABL_WAIT_TIME);
	    ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(by);
	    webDriverWait.until(condition);
    }

	public void waitForElementToBeVisible(WebElement element) {
	    WebDriverWait webDriverWait = new WebDriverWait(driver, GLOABL_WAIT_TIME);
	    ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(element);
	    webDriverWait.until(condition);
    }
		
	public Boolean waitUntilPageWithTitleLoads(String title) {
	    ExpectedCondition<Boolean> condition = ExpectedConditions.titleIs(title);
	    return waitInternalForBoolean(condition,GLOABL_WAIT_TIME);
    }
	
	public Boolean waitUntilPageWithTitleContain(String title) {
	    ExpectedCondition<Boolean> condition = ExpectedConditions.titleContains(title);
	    return waitInternalForBoolean(condition,GLOABL_WAIT_TIME);
    }
	
	public Boolean waitUntilSelectElement(WebElement element) {
		ExpectedCondition<Boolean> condition = ExpectedConditions.elementToBeSelected(element);
		return waitInternalForBoolean(condition,GLOABL_WAIT_TIME);
	}
	
	public Boolean waitUntilTextToBePresent(WebElement element, String text) {
		ExpectedCondition<Boolean> condition = ExpectedConditions.textToBePresentInElement(element, text);
		return waitInternalForBoolean(condition, GLOABL_WAIT_TIME);
	}
	
	
	private Boolean waitInternalForBoolean(ExpectedCondition<Boolean> condition, int timeout) {
	    WebDriverWait webDriverWait = (WebDriverWait) new WebDriverWait(driver, timeout);
	    webDriverWait.ignoring(NoSuchElementException.class)
	    			 .ignoring(StaleElementReferenceException.class);
	    return webDriverWait.until(condition);
  }
	
}
