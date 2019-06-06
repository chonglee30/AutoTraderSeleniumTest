package com.autotrader.tests;

import com.autotrader.pojo.Automobile;
import com.autotrader.pages.HomePage;
import com.autotrader.pages.ResultPage;
import com.autotrader.pojo.AutoType;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
	
	@Test
	public void searchBMWTest() {
		HomePage homePage = new HomePage(getDriver());
		
		// Data-Driven:
		// Case1: Vancouver: V5K 0A1
		// Case2: Port Moody: V3H 1G7
		// Case3: Burnaby: V5G 3H6
		// Case4: Toronto: M4C 1T2
		
		//AutoType.DEFAULT
		Automobile auto = new Automobile("BMW", "3 Series", "15000","New");
		//ResultPage resultPage = homePage.basicSearchForDefaultSelectedAuto(auto, "V5G 3H6");	
		ResultPage resultPage = homePage.basicSearchForNewAutoOnly(auto, "V5G 3H6");
	}
	
	
}
