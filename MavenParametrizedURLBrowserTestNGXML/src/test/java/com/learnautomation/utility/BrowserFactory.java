package com.learnautomation.utility;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

	public class BrowserFactory {

		public static WebDriver startApplication(WebDriver driver, String browserName,String appURL) {
			
			if(browserName.equals("Chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
				
				driver=new ChromeDriver();
				Helper.chromeoptions();
							
			}
			else if(browserName.equals("IE")){
				
				System.setProperty("webdriver.ie.driver", "C:\\Users\\Admin\\Downloads\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
				
			}
			else if(browserName.equals("FireFox")) {
				
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\Downloads\\geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.println("FireFox browser launched");
			}
			
			else {
				System.out.println("we don't support this browser");
		
			}
			
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get(appURL);
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	return driver;
			
		}
		
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	}

		


}
