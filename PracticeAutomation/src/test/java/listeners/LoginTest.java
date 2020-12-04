package listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	public void test1()
	{
		System.out.println("Login to the test1");
		Assert.assertEquals("Rahul", "Rahul");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Login to the test2");
		Assert.assertEquals("Rahul", "Rahul1");
	}

}
