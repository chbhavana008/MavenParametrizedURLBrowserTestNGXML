package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//to handle Screenshots,alerts,frames,windows,synch issues, JavaScript executor
	public static void captureScreenshot(WebDriver driver) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src,new File("./ScreenShots/multibrowser_ "+getCurrentDateTime() +".png"));
			
			System.out.println("screenshot captured");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture screenshot"+e.getMessage());
			
		}
	}
	public static String getCurrentDateTime() {
		
		DateFormat customeformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate=new Date();
		
		return customeformat.format(currentDate);
				
	}
	
	public static void chromeoptions() {
		
		ChromeOptions options = new ChromeOptions();
		
		//System.setProperty("webdriver.ie.driver","C:\\Users\\Admin\\Downloads\\IEDriverServer.exe");
		
		
		options.addArguments("--disable-notifications");
		options.addArguments("chrome.switches","--disable-extensions"); 
		options.addArguments("--disable-save-password");
		options.addArguments("disable-infobars");
	}
	

}
