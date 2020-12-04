package extentReportDemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;



public class extentConcept {
	
	public WebDriver driver;
	public ExtentHtmlReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	@BeforeTest
	public void extentSet()
	{
		reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extentReports/report.html");
		
		reporter.config().setDocumentTitle("Automation Reports");
		reporter.config().setReportName("Functional Report");
		reporter.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Hostname", "LocalHost");
		reports.setSystemInfo("Tester", "Rahul Jathar");
		reports.setSystemInfo("TestCaseID", "Test001");
		reports.setSystemInfo("Browser", "GoogleChrome");
		
	}
	
	@AfterTest
	public void endreport()
	{
		reports.flush();
		
	}
	
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://reg.ebay.in/reg/PartialReg");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void SiteTitle()
	{
		test=reports.createTest("TitleTest");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "rahul");
	}
	
	@Test
	public void logoTest()
	{
		test=reports.createTest("LogoTest");
		test.createNode("Node Created");
		
		boolean logo=driver.findElement(By.xpath("//*[@id=\"pgWidth\"]/div[3]/div/i")).isDisplayed();
		Assert.assertTrue(logo);
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName()+" Test case is failed");
			test.log(Status.FAIL, "Test case is failed "+result.getThrowable());
			
			String screenshotpath=extentConcept.getScreenshot(driver, "rahul");
			test.addScreenCaptureFromPath(screenshotpath);
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName()+" Test case is failed");
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName()+" Test case is success");
			String screenshotpath=extentConcept.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		}
		
		driver.close();
		
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot screen=(TakesScreenshot) driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		String pathname=System.getProperty("user.dir")+"/screenshots/"+screenshotName+".png";
		File destination=new File(pathname);
		FileUtils.copyFile(src, destination);
		return pathname;
		
		
		
		
	}
	

}
