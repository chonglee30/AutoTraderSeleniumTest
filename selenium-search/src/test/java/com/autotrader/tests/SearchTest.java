package com.autotrader.tests;

import com.autotrader.pages.HomePage;
import com.autotrader.pages.ResultPage;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
	
	@Test
	public void searchBMWTest() {
		HomePage homePage = new HomePage(getDriver());
		// Vancouver: V5K 0A1
		// Port Moody: V3H 1G7
		// Burnaby: V5G 3H6
		ResultPage resultPage = homePage.defaultBasicSearchForMakerModelLocation("BMW", "3 Series", "15000", "V5G 3H6");	
	}
	
	
}
