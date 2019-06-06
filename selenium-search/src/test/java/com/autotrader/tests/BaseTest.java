package com.autotrader.tests;

import com.autotrader.config.ConfigProperties;
import com.autotrader.config.SeleniumDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
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
		getSeleuniumDriver().startDriver(ConfigProperties.using().getBrowser());
	}
		
	@BeforeClass
	public void openApplication() {		
		System.out.println("Open ");
		getDriver().get(ConfigProperties.using().getBaseUrl());
	}
	
	@AfterClass
	public void closeApplication() {
		//getDriver().quit();
	}
	
	@AfterTest
	public void teardownDriver() {
		System.out.println("Tear Down Driver");
		getSeleuniumDriver().cleanSeleniumSession();
		getDriver().quit();
	}
}