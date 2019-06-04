package com.autotrader.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectWait {

	private WebDriver driver;
	
	public SelectWait(WebDriver webDriver) {
		this.driver = webDriver;
	}
	
	public static SelectWait using (WebDriver driver) {
		return new SelectWait(driver);
	}

	public void waitForSelectedElement(Select selection) {
		WebElement selectedElement = selection.getFirstSelectedOption();
		boolean elementToBeSelected = DynamicWait.using(driver).waitUntilSelectElement(selectedElement);
		System.out.println("Result: "+elementToBeSelected+" Selected Element: "+selectedElement.getText());

	}
	
	
}
