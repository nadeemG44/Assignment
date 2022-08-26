package com.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.urlConfiguration.UrlConfig;



public class BaseClass 
{
	public  WebDriver driver;
	
	
	public WebDriver launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver",UrlConfig.driverPath);
		driver=new ChromeDriver();
		driver.get(UrlConfig.url);
		driver.manage().window().fullscreen();
		
		return driver;
	}
	
	
	
	

}
