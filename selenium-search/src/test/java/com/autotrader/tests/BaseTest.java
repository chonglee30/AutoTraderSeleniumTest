package com.autotrader.tests;

import com.autotrader.config.ConfigProperties;
import com.autotrader.config.SeleniumDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;

public class BaseTest {

	protected SeleniumDriver getSeleuniumDriver() {
		return SeleniumDriver.getInstance();
	}
	
	protected WebDriver getDriver() {
		return SeleniumDriver.getInstance().getDriver();
	}

	@BeforeTest
	public void setupDriver() {
		System.out.println("Set Up Driver");
	}
		
	@BeforeMethod
	public void openApplication() {		
		System.out.println("Before Method: Open ");
		getSeleuniumDriver().startDriver(ConfigProperties.using().getBrowser());
		getDriver().get(ConfigProperties.using().getBaseUrl());
	}
	
	@AfterMethod
	public void closeApplication() {
		System.out.println("After Method: ");
		getSeleuniumDriver().cleanSeleniumSession();
		getDriver().quit();
	}
	
	@AfterTest
	public void teardownDriver() {
		System.out.println("Tear Down Driver");
	}
}