package com.autotrader.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.autotrader.pojo.Automobile;
import com.autotrader.wait.DynamicWait;

public class ResultPage extends BasePage{

	private String resultPageTitle;		
	private String resultPageHeader;
		
	@FindBy(id="sbCount")
	private WebElement resultCount;
	
	@FindBy(id="faceted-Location")
	private WebElement resultLocation;
	
	public ResultPage(WebDriver driver, Automobile auto) {
		super(driver);
		updateResultPageTitleHeader(auto);
		DynamicWait.using(driver).waitUntilPageWithTitleContain(resultPageTitle);
	}
	
	
	private void updateResultPageTitleHeader(Automobile auto) {
		resultPageTitle = String.format("%s %s %s for sale in ",auto.getType().getAutoType(), auto.getMaker(), auto.getModel());
		resultPageHeader = String.format("%s %s %s for sale in ",auto.getType().getAutoType(), auto.getMaker(), auto.getModel());
		System.out.println("Result Page Title: "+resultPageTitle);
		System.out.println("Result Page Header: "+resultPageHeader);
	}
		
}