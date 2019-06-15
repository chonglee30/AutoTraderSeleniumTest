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
	
	//why do you need to use a static driver? that is totally unnecessary
	protected SeleniumDriver getSeleuniumDriver() {
		return SeleniumDriver.getInstance();
	}
	
	protected WebDriver getDriver() {
		return SeleniumDriver.getInstance().getDriver();
	}

	@BeforeTest
	public void setupDriver() {
		//what is the need for the next line?
		System.out.println("Set Up Driver");
	}
		
	@BeforeMethod
	public void openApplication() {		
		System.out.println("Before Method: Open ");
		
		//i am assuming that startDriver() is also static; i find this unneccesary
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
