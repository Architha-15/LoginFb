package com.selenium.common;

import java.io.Reader;
import java.util.ArrayList;

public class DataproviderUtils {
	static Xls_Reader reader;
	 
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader=new Xls_Reader("C:\\Users\\Annangi\\eclipse-workspace\\practiceMaven\\src\\test\\resources\\FbLogin.xlsx");
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("fbdetails");rowNum++) {
			String uname=reader.getCellData("fbdetails", "username", rowNum);
			String pwd=reader.getCellData("fbdetails", "password", rowNum);
			
			Object ob[]= {uname,pwd};
			myData.add(ob);
		}
		return myData;
		
		
		
	}

}
