package com.autotrader.pages;

import com.autotrader.pojo.Automobile;
import com.autotrader.wait.DynamicWait;
import com.autotrader.pages.components.BasicAutoSearchTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private static final String title ="New & Used Cars for Sale – Auto Classifieds";
	private BasicAutoSearchTab basicAutoSearchTab;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.basicAutoSearchTab = new BasicAutoSearchTab(driver);
		DynamicWait.using(driver).waitUntilPageWithTitleLoads(title);
	}
	
	private void unselectOtherAutoTypes(WebElement firstCheckbox, WebElement secondCheckbox) {
		unselectCheckboxJS(firstCheckbox);
		unselectCheckboxJS(secondCheckbox);
	}
	
	private void selectAutoType(Automobile auto) {
		if (auto.getAutoType().equals("New")) {
			WebElement usedElement = basicAutoSearchTab.getAutoTypeCheckbox().getUsedCheckbox();
			WebElement preOwnedElement = basicAutoSearchTab.getAutoTypeCheckbox().getPreOwnedCheckbox();
			unselectOtherAutoTypes(usedElement,preOwnedElement);
		} else if (auto.getAutoType().equals("Used")) {
			WebElement newElement = basicAutoSearchTab.getAutoTypeCheckbox().getNewCheckbox();
			WebElement preOwnedElement = basicAutoSearchTab.getAutoTypeCheckbox().getPreOwnedCheckbox();
			unselectOtherAutoTypes(newElement,preOwnedElement);
		} else if (	(auto.getAutoType().equals("Pre-Owned"))) {
			WebElement newElement = basicAutoSearchTab.getAutoTypeCheckbox().getNewCheckbox();
			WebElement preOwnedElement =basicAutoSearchTab.getAutoTypeCheckbox().getUsedCheckbox();
			unselectOtherAutoTypes(newElement,preOwnedElement);
		}			
	}
	
	public ResultPage autoSearchByPostalCode(Automobile auto) {
		selectAutoType(auto);		
		basicAutoSearchTab.getAutoMakeModelLists().selectMakes(auto.getMaker());
		basicAutoSearchTab.getAutoMakeModelLists().selectModel(auto.getModel());
		basicAutoSearchTab.selectPrice(auto.getMaxPrice());
		basicAutoSearchTab.enterLocationAddress(auto.getLocation().getPostalCode());
		basicAutoSearchTab.clickSearchButton();
			
		return new ResultPage(driver, auto);
	} 
}