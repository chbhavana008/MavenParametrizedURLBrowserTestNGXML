package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.learnautomation.utility.Helper;

public class LoginPage {
	
	public WebDriver driver;	
		
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		//PageFactory.initElements(driver, this);//if not defined in LoginTestBook class ,then define here
	
	}
	
	@FindBy(how=How.ID,id="email") WebElement Id;
	
	@FindBy(how=How.NAME,name="pass") WebElement Password;
	
	@FindBy(how=How.XPATH,xpath="//input[@type='submit']") WebElement submit;
	
	
	public void loginToFacebook(String Username, String pwd) {
		Helper.chromeoptions();
		Id.sendKeys(Username);
		Password.sendKeys(pwd);
		submit.click();
				
	}
	
	
	
}
