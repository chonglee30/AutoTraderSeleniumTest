package com.autotrader.tests;

import com.autotrader.pojo.Automobile;
import com.autotrader.pojo.Location;
import com.autotrader.files.ReadFile;
import com.autotrader.pages.HomePage;
import com.autotrader.pages.ResultPage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Iterator;
import org.testng.Assert;

public class SearchTest extends BaseTest{
	
	@Test (dataProvider="search-data")
	public void autoInfoSearchTest(String make, String model, String maxPrice,
					  String type, String postalCode, String city) {
		
		HomePage homePage = new HomePage(getDriver());
		
		Location location = new Location(postalCode, city);
		Automobile auto = new Automobile(make, model,maxPrice,type,location);
		ResultPage resultPage = homePage.autoSearchByPostalCode(auto);
		Assert.assertTrue(resultPage.isSearchResultContain());
		Assert.assertTrue(resultPage.isAutoInfoCorrectlyDisplay());	
		Assert.assertTrue(resultPage.isCityCorrectlyDisplay());
	}
		
	@DataProvider(name="search-data")
	public Iterator<Object[]> getSearchData() {
		String fileToParse = "AutoSearchData.csv";
		return ReadFile.using().readSearchData(fileToParse);
	}
}