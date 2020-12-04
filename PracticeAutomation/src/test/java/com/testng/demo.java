package com.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class demo {
	
	@BeforeMethod
	public void demo1()
	{
		System.out.println("beforemethod");
	}
	
	
	@Test
	public void mai()
	{
		System.out.println("DEMO");
	}
	
	public void demo12()
	{
		System.out.println("Demo123");
	}
	

}
