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
		
		//this should not happen in the constructor
		updateResultPageTitleHeader(auto);
		
		DynamicWait.using(driver).waitUntilPageWithTitleContain(resultPageTitle);
	}

	//methods that update class variables should be avoided because they lead to weird coupling
	//if they are not executed and other methods depend on them, the execution becomes unpredictable
	private void updateResultPageTitleHeader(Automobile auto) {
		resultPageTitle = String.format("%s %s %s for sale in ",auto.getType().getAutoType(), auto.getMaker(), auto.getModel());
		resultPageHeader = String.format("%s %s %s for sale in ",auto.getType().getAutoType(), auto.getMaker(), auto.getModel());
		autoInfo = String.format("%s %s %s", auto.getType().getAutoType(), auto.getMaker(), auto.getModel());
		city = auto.getLocation().getCity();
	}

	//what does this do? i have no clue
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
	
	//it is unclear from the method title what it does
	public boolean isSearchResultContain() {
		int searchCount = Integer.valueOf(resultCount.getText());
		
		//next line can just be return searchCount > 0;
		return ((searchCount>0)?true:false);
	}
	
	//no clue what this does
	public Boolean isAutoInfoCorrectlyDisplay() {
		int autoInfoLastIndex = getAutoInfoIndex("for") - SPACE;
		String autoInfoDisplay = txtHeader.substring(0, autoInfoLastIndex);
		return (autoInfo.equals(autoInfoDisplay)? true:false);
	}

	//why do you need to check on the city?
	public Boolean isCityCorrectlyDisplay() {
		String indexWord = "in";	
		int indexwordSize = indexWord.length();		
		int cityFirstIndex = getAutoInfoIndex(indexWord) +indexwordSize+SPACE;
		int cityLastIndex = txtHeader.length();
		String cityInfoDisplay = txtHeader.substring(cityFirstIndex, cityLastIndex);
		return (city.equals(cityInfoDisplay)? true:false);
	}	
}
