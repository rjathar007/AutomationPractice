package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parametersConcept {
	
	WebDriver driver;
	
	@Test
	@Parameters({"url","search"})
	public void paraDemo(String url, String search)
	{
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(search);
	}
	
	@Test
	public void paraDemo1()
	{
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/testng/testng-parallel-execution/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

}
