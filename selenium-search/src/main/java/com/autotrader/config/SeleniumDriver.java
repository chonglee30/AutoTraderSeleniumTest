package com.autotrader.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private DesiredCapabilities browserCapabilities = null;
	 
    private static SeleniumDriver instance = new SeleniumDriver();
    
    private SeleniumDriver() {	
    }
    
    public static SeleniumDriver getInstance() {
    	return instance;
    }
      
    //what happens if the browser is neither chrome not firefox?
    public void startDriver(String browser) {
        try {
          DesiredCapabilities cap = new DesiredCapabilities();
          cap.setBrowserName(browser);
          
          if (browser.equals("firefox")) { 
        	  this.browserCapabilities = DesiredCapabilities.firefox();
              FirefoxProfile customProfile = new FirefoxProfile();
              customProfile.setPreference("dom.disable_beforeunload", true);
              driver.set(new FirefoxDriver(this.browserCapabilities));
          } else if (browser.equals("chrome")) {
          	  WebDriverManager.chromedriver().setup();
              this.browserCapabilities = DesiredCapabilities.chrome();             
              driver.set(new ChromeDriver(this.browserCapabilities));
            }
          
	//implicit waits are a bad practice
         driver.get().manage().timeouts().implicitlyWait(ConfigProperties.using().getImplicitWait(), TimeUnit.SECONDS);
         driver.get().manage().window().maximize(); 
        } catch (Exception e) {
        	e.printStackTrace();
          }
     }
	
	//no need to delete cookies since each session is clean
	public void cleanSeleniumSession() {
        try {
          driver.get().manage().deleteAllCookies();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
}
