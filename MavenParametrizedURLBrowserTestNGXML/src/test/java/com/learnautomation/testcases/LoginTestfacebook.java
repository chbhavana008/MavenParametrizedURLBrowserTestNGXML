package com.learnautomation.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class LoginTestfacebook extends BaseClass {
	
	@Test
	public void loginApp() throws Exception {
		
		ExcelDataProvider excel = new ExcelDataProvider();
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
			
		loginpage.loginToFacebook(excel.getStringData("Login",0,0), excel.getStringData("Login",0,1));
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		Assert.assertEquals(driver.getTitle(), "facebook");
		
		Helper.captureScreenshot(driver);
				
		}
		
				
	}