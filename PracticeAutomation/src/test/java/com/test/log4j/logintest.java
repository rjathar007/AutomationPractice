package com.test.log4j;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class logintest {
	
	WebDriver driver;
	
	Logger log=Logger.getLogger(logintest.class);
	
	@BeforeMethod
	public void setup()
	{
		//System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		log.info("Browser Launch");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://ui.freecrm.com/");
		log.warn("Warning message");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void freeCrmTitleTest()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title, "Rahul");
		
	}
	
	@Test(priority=2)
	public void logoTest()
	{
			
		boolean logo=driver.findElement(By.xpath("//*[@id=\"pgWidth\"]/div[3]/div/i")).isDisplayed();
		Assert.assertTrue(logo);
		
	}

}
