package com.autotrader.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.autotrader.pojo.Automobile;
import com.autotrader.wait.DynamicWait;

public class ResultPage extends BasePage{

	private WebDriver driver;
	private String resultPageTitle;		
	private String resultPageHeader;
	private String autoInfo;
	private String city;
	
	@FindBy(id="sbCount")
	private WebElement resultCount;
	
	@FindBy(id="titleText")
	private WebElement pageHeader;
	private String txtHeader;
	
	@FindBy(id="faceted-Location")
	private WebElement resultLocation;
	int SPACE=1;
	
	public ResultPage(WebDriver driver, Automobile auto) {
		super(driver);
		this.driver = driver;
		updateResultPageTitleHeader(auto);
		DynamicWait.using(driver).waitUntilPageWithTitleContain(resultPageTitle);
	}

	private void updateResultPageTitleHeader(Automobile auto) {
		resultPageTitle = String.format("%s %s %s for sale in ",auto.getType().getAutoType(), auto.getMaker(), auto.getModel());
		resultPageHeader = String.format("%s %s %s for sale in ",auto.getType().getAutoType(), auto.getMaker(), auto.getModel());
		autoInfo = String.format("%s %s %s", auto.getType().getAutoType(), auto.getMaker(), auto.getModel());
		city = auto.getLocation().getCity();
	}

	private int getAutoInfoIndex(String searchWord) {
		txtHeader = pageHeader.getText();
		String []headerWords = txtHeader.split(" ");
		int index=0;
		
		for (String word : headerWords) {
			if (word.equals(searchWord)) {
				index = txtHeader.indexOf(searchWord); 
				return index;
			}
		}
		return index;
	}
	
	public boolean isSearchResultContain() {
		int searchCount = Integer.valueOf(resultCount.getText());
		return ((searchCount>0)?true:false);
	}
	
	public Boolean isAutoInfoCorrectlyDisplay() {
		int autoInfoLastIndex = getAutoInfoIndex("for") - SPACE;
		String autoInfoDisplay = txtHeader.substring(0, autoInfoLastIndex);
		return (autoInfo.equals(autoInfoDisplay)? true:false);
	}

	public Boolean isCityCorrectlyDisplay() {
		String indexWord = "in";	
		int indexwordSize = indexWord.length();		
		int cityFirstIndex = getAutoInfoIndex(indexWord) +indexwordSize+SPACE;
		int cityLastIndex = txtHeader.length();
		String cityInfoDisplay = txtHeader.substring(cityFirstIndex, cityLastIndex);
		return (city.equals(cityInfoDisplay)? true:false);
	}	
}