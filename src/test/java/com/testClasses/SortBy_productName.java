package com.testClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.pomClasses.ShopBy_category;
import com.utility.Utility;;

@Test
public class SortBy_productName extends BaseClass {
	ShopBy_category shopByCategory;
	Utility utility;
	BaseClass baseClass;
	String TCID;
	WebDriver driver;
	
	
	@BeforeMethod
	public void objInitialization() {
		driver = launchBrowser();
		
		shopByCategory = new ShopBy_category(driver);
		utility = new Utility();
		}

	
	  @Test
	  public void SortByProductName() throws InterruptedException 
	  {
		  TCID="102";
		  Reporter.log("TEST-CASE-01 failed: Before-sorted elements compaired");
	  
		  	List<String> productByName = utility.sortByProductName(driver);
		  	Collections.sort(productByName);
		  	
		  		Assert.assertTrue(productByName.get(0).equals(productByName.get(1)));
	  }
	  
	  
    @Test(priority=1)
    public void SortByProductPrice() 
	{
		 TCID="103";
	     Reporter.log("TEST-CASE-02 failed: Non-sorted elements compared with  Sorted-Elements ");
		  
		 List<String> productByPrice = utility.sortByProductPrice(driver);
	     Collections.sort(productByPrice);
	  	
	  		Assert.assertTrue(productByPrice.get(0).equals(productByPrice.get(1)));
	}
    
    
     @AfterMethod
     public void checkFailTestCase(ITestResult res) throws IOException 
	  { 
		  // Here listeners are used to check failed status to generate screen-shot
		  
		  		if(ITestResult.FAILURE==res.getStatus()) 
		  		{
		  			Utility.captureScreenshot(driver, TCID);
		  		}
	  }

	
	  @AfterClass 
	  public void closeTab() 
	  { driver.close(); 
	  }
	 

}
