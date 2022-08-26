package com.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility
{
	
	
	public static void captureScreenshot(WebDriver drive,String tcID) throws IOException
	{
		File src=((TakesScreenshot)drive).getScreenshotAs(OutputType.FILE);
		File desti=new File(com.urlConfiguration.UrlConfig.screenShots+tcID+"_Image.jpg");
		FileHandler.copy(src, desti);
	}



	public List<String> sortByProductName(WebDriver driver)
	{	
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		List<WebElement> beforeFilter =	driver.findElements(By.className("product-item-link")); 
		  
		List<String> li=new  ArrayList<String>();
				for(WebElement bf:beforeFilter)
						{ 
							String elementsBeforeSort = bf.getText();
							System.out.println(elementsBeforeSort);
							li.add(elementsBeforeSort); 
						}
							Collections.sort(li);
		  //--------------------------------------------------------------------------  
	         driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	 List<String> li1=new ArrayList<String>();
		    
		 try {
			 	WebElement sortBy1=driver.findElement(By.xpath("(//select[@id='sorter'])[1]")); 
		      	Select s=new Select(sortBy1); 
		      	s.selectByValue("name");
		      		List<WebElement> afterSortByName=driver.findElements(By.className("product-item-link"));
				 //	List<String> finalSort2 = li1.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

					for(WebElement af:afterSortByName)
					{
						String elementsAfterSort = af.getText();
						li1.add(elementsAfterSort); 
					}
					Collections.sort(li1);
			} 
		 	catch (StaleElementReferenceException e) 
		 			{
		 			e.getMessage();
		 			}   
		 
        List<String> list=new ArrayList<>();
		  	list.addAll(li);
		  	list.addAll(li1);
		  	
		  	return list;
	      		      	
	}
	
	
	
	public List<String> sortByProductPrice(WebDriver driver)
	{
		List<WebElement> beforeSort = driver.findElements(By.xpath("//span[@class='special-price']//span[@class='price']"));
		List<String> li=new ArrayList<>();

		for (WebElement bf : beforeSort) 
 		{
 			String text = bf.getText().replaceAll("[^0-9]","");
 			li.add(text);
 			System.out.println(text);
 		}
		
		Collections.sort(li);
		
		
		
		List<String> li1=new ArrayList<>();
		try {
			WebElement sortBy1=driver.findElement(By.xpath("(//select[@id='sorter'])[1]"));
		     Select s=new Select(sortBy1); 
		     s.selectByValue("price");
		     
		     List<WebElement> aftereSort = driver.findElements(By.xpath("//span[@class='special-price']//span[@class='price']"));
			
		     for (WebElement af : aftereSort) 
				{
					String text = af.getText().replaceAll("[^0-9]","");
					System.out.println(text);
					li1.add(text);
				}
		     Collections.sort(li1);
			} 
			catch (StaleElementReferenceException e) 
				{
					e.getMessage();
				}
		
		List<String> list=new ArrayList<>();
	  	list.addAll(li);
	  	list.addAll(li1);
		
		return list;
		
	}
	
	
	
	
	
}
