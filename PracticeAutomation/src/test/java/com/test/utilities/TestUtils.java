package com.test.utilities;

import java.util.ArrayList;

public class TestUtils {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
		try {
			reader=new Xls_Reader("");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		for (int rownum = 2; rownum <= reader.getRowCount("Sheet1"); rownum++) {
			
			String firstname=reader.getCellData("Sheet1", "firstname", rownum);
			String lastname=reader.getCellData("Sheet1", "lastname", rownum);
			String email=reader.getCellData("Sheet1", "email", rownum);
			String password=reader.getCellData("Sheet1", "password", rownum);
			
			
			Object ob[]= {firstname,lastname,email,password};
			mydata.add(ob);
			
		}
		
		return mydata;
		
	}

}
