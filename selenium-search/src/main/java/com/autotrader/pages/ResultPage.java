package com.autotrader.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.autotrader.wait.DynamicWait;

public class ResultPage extends BasePage{

	private String resultPageTitle;		
	private String resultPageHeader;
	
	private String maker;
	private String model;
	
	@FindBy(id="sbCount")
	private WebElement resultCount;
	
	@FindBy(id="faceted-Location")
	private WebElement resultLocation;
	
	public ResultPage(WebDriver driver, String autoMaker, String autoModel) {
		super(driver);
		updateResultPageTitleHeader(autoMaker, autoModel);
		DynamicWait.using(driver).waitUntilPageWithTitleContain(resultPageTitle);
	}
	
	private void setMakerModel(String autoMaker, String autoModel) {
		maker = autoMaker;
		model = autoModel;
	}
	
	private void updateResultPageTitleHeader(String autoMaker, String autoModel) {
		setMakerModel(autoMaker, autoModel);
		resultPageTitle = String.format("New & Used %s %s for sale in ", maker, model);
		resultPageHeader = String.format("New & Used %s %s for sale in ", maker, model);
	}
		
}