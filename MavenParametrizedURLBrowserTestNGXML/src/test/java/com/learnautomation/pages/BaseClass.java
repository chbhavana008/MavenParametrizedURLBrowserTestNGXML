package com.learnautomation.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	
	public ExcelDataProvider excel;
	
	public ConfigDataProvider config;
	
	
	@BeforeSuite
	public void setUpSuite() throws IOException
	{
				
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
	}
	
	@BeforeClass
	public void setup() 
	{	
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingURL());	
		Helper.chromeoptions();			
	}
	
	/*
	 * @AfterClass public void quitbrowser() {
	 * 
	 * BrowserFactory.quitBrowser(driver);
	 * 
	 * }
	 */
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE) {
			
			
			System.out.println("screenshot captured");
		}
				
	}
}
