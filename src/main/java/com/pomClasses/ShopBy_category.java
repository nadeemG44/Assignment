package com.pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopBy_category 
{
	@FindBy(xpath="(//select[@id='sorter'])[1]") private WebElement sortBy;
//	@FindBy(xpath="//a[@class='product-item-link']") private WebElement allElements;
	
	public ShopBy_category(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void click()
	{
		sortBy.click();
	}

}
