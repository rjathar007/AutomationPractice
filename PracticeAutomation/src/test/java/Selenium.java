import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Rahul");
		
		//Thread.sleep(2000);
		
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1 sbl1p']//span"));
		
		System.out.println("Size of suggestions : "+list.size());
		
		for(int i=0; i<list.size(); i++)
		{
			String str=list.get(i).getText();
			System.out.println("Printing all the suggestions");
			System.out.println(str);
			
			if(str.equalsIgnoreCase("rahul dravid"))
			{
				list.get(i).click();
				System.out.println("Clicked on given suggestion");
			}
		}
	}

}
