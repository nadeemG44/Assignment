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
	  
	  // id is set for screenshot
		  	TCID="102";
	  
	  // logs are provided for failed test case in emailable report
		  	Reporter.log("TEST-CASE-01 failed: Before-sorted elements compaired");
	  
	  
	   // All the product-names on webPage are taking into variable by xpath
		  	List<WebElement> beforeFilter =	driver.findElements(By.className("product-item-link")); 
		  
		 // Generic ArrayList created to add webElements in form of string
		  		List<String> li=new  ArrayList<String>();
	  
		  		
		
		  		//  All webElements are iterated using for-loop
		  					for(WebElement bf:beforeFilter)
		  						{ 
		  							String elementsBeforeSort = bf.getText();
		  							li.add(elementsBeforeSort); 
		  						}
		  					
		  			
		  		// string elements (list) sorted in asending order
		  				Collections.sort(li);
		  						//	Collections.sort(li,Collections.reverseOrder());
	  
	  //---------------------------------------------------------------------------
	  
	  
	      driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	  
	     //  drop-down handled by using Select class
	      	WebElement sortBy1=driver.findElement(By.xpath("(//select[@id='sorter'])[1]")); 
	      	Select s=new Select(sortBy1); 
	      	s.selectByValue("name");
	  
	  
	  
	     // All the product-names on webPage are taking into variable by xpath
	      	List<WebElement> afterSortByName=driver.findElements(By.className("product-item-link"));
	  
	       // Generic ArrayList created to add webElements in form of string
	      		List<String> li1=new ArrayList<String>(); 
	 
	      		 //  not-sorted web elements are sorted by "stream()"		
	      			List<String> finalSort2 = li1.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
	  
	      		//  All webElements are iterated using for-loop
	      				for(WebElement af:afterSortByName)
	      					{
	      						String elementsAfterSort = af.getText();
	      						li1.add(elementsAfterSort); 
	      					}
	  
	      				//// string elements (list) sorted in asending order
	      						//Collections.sort(li1);
	  
	   //  Assertion is used to verify the outcome
	   Assert.assertTrue(li.equals(li1));
	   
  }
	 
    @Test(priority=1)
	public void SortByProductPrice() 
	{
		
	//   id is set for screenshot
		 TCID="103";
		 
	   // logs are provided for faild test case in emailable report 
		  Reporter.log("TEST-CASE-02 failed: Non-sorted elements compared with  Sorted-Elements ");
		  
         //  All the product-names on webPage are taking into variable by xpath
		  	List<WebElement> beforeSort = driver.findElements(By.xpath("//span[@class='special-price']//span[@class='price']"));
		
		  	
		   // Generic ArrayList created to add webElements in form of string
		         List<String> li1=new ArrayList<>();

		     //  All webElements are iterated using for-loop
		         	for (WebElement bf : beforeSort) 
		         		{
		         			String text = bf.getText().replaceAll("[^0-9]","");
		         			li1.add(text);
		         			System.out.println(text);
		         		}
		         	
	//  non-sorted web elements are sorted by	
		Collections.sort(li1);
		
/*------------------------------------------------------------------------------------------------------------*/
		
		 driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		 
	//  All the product-names on webPage are taking into variable by xpath 
		
       //  drop-down handled by using Select class
		     WebElement sortBy1=driver.findElement(By.xpath("(//select[@id='sorter'])[1]"));
		     Select s=new Select(sortBy1); 
		     s.selectByValue("price");

		    // All the product-names on webPage are taking into variable by xpath
		       List<WebElement> aftereSort = driver.findElements(By.xpath("//span[@class='special-price']//span[@class='price']"));
		
		 
      // Generic ArrayList created to add webElements in form of string		       
		List<String> li2=new ArrayList<>();
		
		  //  All webElements are iterated using for-loop	
			for (WebElement af : aftereSort) 
				{
					String text = af.getText().replaceAll("[^0-9]","");
					System.out.println(text);
					li2.add(text);
				}
			
		//  non-sorted web elements are sorted by	
		//	Collections.sort(li2);
			
	      //  Assertion is used to verify the outcome
		      Assert.assertTrue(li1.equals(li2));
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

	
	/*  @AfterClass 
	  public void closeTab() 
	  { driver.close(); 
	  }*/
	 

}
