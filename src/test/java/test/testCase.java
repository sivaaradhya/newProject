package test;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import log.loginPage;
import utility.ReadConfig;

public class testCase {
	WebDriver driver;
	public static Logger logger= Logger.getLogger("ebanking");
	ReadConfig config=new ReadConfig();
	@BeforeMethod
	public void setup()
	{
		PropertyConfigurator.configure(".\\config\\Log4j.properties.txt");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@AfterMethod
	public void destory()
	{
		driver.quit();
	}
	public void captureScreenshot(WebDriver driver, String tname)  {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\Screenshot\\" + tname + ".png");
	    try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
}
	@Test
	
	public void loginTestWithVaildCredentials()  {
		logger.info("stat");
		driver.get(config.getApplicationURL());
		logger.info("https://demo.guru99.com/V4/index.php");
		loginPage LoginPage=new loginPage(driver);
		logger.info("loginPage objects");
		LoginPage.enterUserId(config.getuserName());
		logger.info("enterUserId info");
		LoginPage.enterpassword(config.getpassword());
		logger.info("enterpassword info");
		LoginPage.clickLogin();
		
		String ActualTitle=driver.getTitle();
		String exceptedTitle="Guru99 Bank Manager ";
		//Assert.assertEquals(ActualTitle, exceptedTitle);
		if(ActualTitle.equals(exceptedTitle))
		{
			Assert.assertTrue(true);
		}else
		{
			
			captureScreenshot(driver,"loginTestWithVaildCredentials");
			Assert.assertTrue(false);
		}
		
	}
	
}



