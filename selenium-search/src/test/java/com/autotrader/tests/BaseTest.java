package com.autotrader.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.WebDriver;

import com.autotrader.config.ConfigProperties;
import com.autotrader.config.SeleniumDriver;

public class BaseTest {

	protected SeleniumDriver getSeleuniumDriver() {
		return SeleniumDriver.getInstance();
	}
	
	protected WebDriver getDriver() {
		return SeleniumDriver.getInstance().getDriver();
	}
	
	@BeforeClass
	public void setupDriver() {		
		System.out.println("Set Up Driver");
		getSeleuniumDriver().startDriver(ConfigProperties.using().getBrowser());
		getDriver().get(ConfigProperties.using().getBaseUrl());
	}
	
	@AfterClass
	public void quitDriver() {
		System.out.println("Tear Down Driver");
		getSeleuniumDriver().cleanSeleniumSession();
		getDriver().quit();
	}
	
}