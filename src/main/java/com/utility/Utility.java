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

	
	
	
}
