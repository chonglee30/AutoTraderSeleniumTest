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
	
	//the name of the test should explain what the test does; this name is totally confusing
	@Test (dataProvider="search-data")
	public void autoInfoSearchTest(String make, String model, String maxPrice,
					  String type, String postalCode, String city) {
		
		HomePage homePage = new HomePage(getDriver());
		
		Location location = new Location(postalCode, city);
		Automobile auto = new Automobile(make, model,maxPrice,type,location);
		
		//search() is better since there are other parameters in addition to the postal code
		ResultPage resultPage = homePage.autoSearchByPostalCode(auto);
		
		//what exactly does this assertion check for?
		Assert.assertTrue(resultPage.isSearchResultContain());
		
		//which info is checked?
		Assert.assertTrue(resultPage.isAutoInfoCorrectlyDisplay());	
		Assert.assertTrue(resultPage.isCityCorrectlyDisplay());
	}
		
	@DataProvider(name="search-data")
	public Iterator<Object[]> getSearchData() {
		String fileToParse = "AutoSearchData.csv";
		
		//again static methods
		//static methods are a bad idea in general unless you build a framework
		//object oriented code uses objects and not static variables and static methods
		return ReadFile.using().readSearchData(fileToParse);
	}
}
