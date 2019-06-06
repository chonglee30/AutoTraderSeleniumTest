package com.autotrader.pages;

import com.autotrader.pojo.Automobile;
import com.autotrader.wait.DynamicWait;
import com.autotrader.wait.StaticWait;
import com.autotrader.wait.SelectWait;

import com.autotrader.pages.components.BasicAutoSearchTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

	private static final String title ="New & Used Cars for Sale – Auto Classifieds";
	private BasicAutoSearchTab basicAutoSearchTab;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.basicAutoSearchTab = new BasicAutoSearchTab(driver);
		DynamicWait.using(driver).waitUntilPageWithTitleLoads(title);
	}
	
	/*	
	public ResultPage basicSearchForDefaultSelectedAuto(Automobile auto, String location) {
		
		basicAutoSearchTab.getAutoMakeModelLists().selectMakes(auto.getMaker());
		basicAutoSearchTab.getAutoMakeModelLists().selectModel(auto.getModel());
		basicAutoSearchTab.selectPrice(auto.getMaxPrice());
		basicAutoSearchTab.enterLocationAddress(location);
		basicAutoSearchTab.clickSearchButton();
			
		return new ResultPage(driver, auto);
	}	*/
	
	
	
	
	
	public ResultPage basicSearchForNewAutoOnly(Automobile auto, String location) {
		
		//WebElement usedElement = basicAutoSearchTab.getAutoTypeCheckbox().getUsedCheckbox();
		//WebElement preOwnedElement = basicAutoSearchTab.getAutoTypeCheckbox().getPreOwnedCheckbox();
		
		WebElement usedElement = basicAutoSearchTab.getUsedCheckbox();
		WebElement preOwnedElement = basicAutoSearchTab.getPreOwnedCheckbox();
		
		basicAutoSearchTab.unselectCheckbox(usedElement);
		basicAutoSearchTab.unselectCheckbox(preOwnedElement);
		//unselectCheckbox(usedElement); 
		//unselectCheckbox(preOwnedElement);
		
		basicAutoSearchTab.getAutoMakeModelLists().selectMakes(auto.getMaker());
		basicAutoSearchTab.getAutoMakeModelLists().selectModel(auto.getModel());
		basicAutoSearchTab.selectPrice(auto.getMaxPrice());
		basicAutoSearchTab.enterLocationAddress(location);
		basicAutoSearchTab.clickSearchButton();
			
		return new ResultPage(driver, auto);
	}
	
	
	
	/* 
	public ResultPage basicSearchForUsedAutoOnly(String autoMaker, String autoModel,
			 String autoPrice, String location) {

		unselectNewCheckbox(chkboxNew); 
		unselectNewCheckbox(chkboxPreOwned);
		
		selectMakes(autoMaker);
		selectModel(autoModel);
		selectPrice(autoPrice);
		enterLocationAddress(location);
		clickSearchButton();
		return new ResultPage(driver, autoMaker, autoModel);
	}
	
	public ResultPage basicSearchForPreOwnedAutoOnly(String autoMaker, String autoModel,
			 String autoPrice, String location) {

		unselectNewCheckbox(chkboxNew);
		unselectNewCheckbox(chkboxUsed); 
		
		selectMakes(autoMaker);
		selectModel(autoModel);
		selectPrice(autoPrice);
		enterLocationAddress(location);
		clickSearchButton();
		return new ResultPage(driver, autoMaker, autoModel);
	}	
	*/

}