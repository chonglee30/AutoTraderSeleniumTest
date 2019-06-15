package com.autotrader.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.autotrader.wait.SelectWait;

public class AutoMakeModelLists {

	private WebDriver driver;
	
	private final By SELECT_MAKE = By.id("rfMakes"); 
	private String maker;
	
	private final By SELECT_MODEL = By.id("rfModel");
	private String model;
	
	public AutoMakeModelLists(WebDriver driver) {
		this.driver = driver;
	}
	
	//it is bad to save autoMaker in maker since maker is a class variable
	//a method should only work on itself
	public void selectMakes(String autoMaker) {
		WebElement makeElement = driver.findElement(SELECT_MAKE);
		Select make = new Select(makeElement);
		make.selectByValue(autoMaker);
		maker = autoMaker;		
		SelectWait.using(driver).waitForSelectedElement(make);
	}
	
	//see above
	public void selectModel(String autoModel) {
		WebElement modelElement = driver.findElement(SELECT_MODEL);
		Select selModel = new Select(modelElement);
		selModel.selectByValue(autoModel);
		model = autoModel;
		SelectWait.using(driver).waitForSelectedElement(selModel);
	}

	public String getMaker() {
		return maker;
	}
	
	public String getModel() {
		return model;
	}

}
