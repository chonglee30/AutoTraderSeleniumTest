package com.autotrader.pages;

import com.autotrader.wait.DynamicWait;
import com.autotrader.wait.StaticWait;
import com.autotrader.wait.SelectWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

	private static final String title ="New & Used Cars for Sale – Auto Classifieds";
	
	@FindBy(id="rfMakes")
	private WebElement selectMakes;
	private String maker;
	
	@FindBy(id="rfModel")
	private WebElement selectModel;
	private String model;
	
	@FindBy(id="rfPriceHigh")
	private WebElement selectMaxPrice;
	
	@FindBy(id="locationAddress")
	private WebElement inputLocation;
	private String location;
	
	@FindBy(id="SearchButton")
	private WebElement btnSearch;
	
	public HomePage(WebDriver driver) {
		super(driver);
		DynamicWait.using(driver).waitUntilPageWithTitleLoads(title);
	}
	
	// 
	public ResultPage defaultBasicSearchForMakerModelLocation(String autoMaker, String autoModel,
											 String autoPrice, String location) {
		
		selectMakes(autoMaker);
		selectModel(autoModel);
		selectPrice(autoPrice);
		enterLocationAddress(location);
		clickSearchButton();
		return new ResultPage(driver, autoMaker, autoModel);
	}
	
	public String getMaker() {
		return maker;
	}
	
	public String getModel() {
		return model;
	}
	
	// Wait Utility Function:
	private void waitForSelectedElement(Select selection) {
		WebElement selectedElement = selection.getFirstSelectedOption();
		boolean elementToBeSelected = DynamicWait.using(driver).waitUntilSelectElement(selectedElement);
		System.out.println("Result: "+elementToBeSelected+" Selected Element: "+selectedElement.getText());

	}
	
	private void selectMakes(String autoMaker) {
		Select make = new Select(selectMakes);
		make.selectByValue(autoMaker);
		maker = autoMaker;		
		SelectWait.using(driver).waitForSelectedElement(make);
	}
	
	private void selectModel(String autoModel) {
		Select selModel = new Select(selectModel);
		selModel.selectByValue(autoModel);
		model = autoModel;
		SelectWait.using(driver).waitForSelectedElement(selModel);
	}
	
	private void selectPrice(String autoPrice) {
		Select price = new Select(selectMaxPrice);
		price.selectByValue(autoPrice);		
		SelectWait.using(driver).waitForSelectedElement(price);
	}
	
	private void enterLocationAddress(String autoLocation) {
		location = autoLocation;
		type(inputLocation, autoLocation);
		System.out.println("Text Input: "+getInputValue(inputLocation));
	}
	
	private void clickSearchButton() {
		click(btnSearch);
	}
	
}