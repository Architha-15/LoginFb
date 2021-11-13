package com.selenium.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.poifs.nio.FileBackedDataSource;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class WriteExcelFb {
	public static void main(String[] args) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("fbdetails");
		
		ArrayList< Object[]> fbdata = new ArrayList<Object[]>();
		fbdata.add(new Object[] {"username", "password"});
		fbdata.add(new Object[] {"jim", "jim123"});
		fbdata.add(new Object[] {"jack", "jack123"});
		fbdata.add(new Object[] {"john", "john123"});
		
		int rowNum=0;
		for (Object[] data : fbdata) {
			XSSFRow row=sheet.createRow(rowNum++);
			int cellNum=0;
			for (Object value : data) {
				XSSFCell cell =row.createCell(cellNum++);
				
				if(value instanceof String) {
					cell.setCellValue((String)value);
				}
				
				if(value instanceof Integer) {
					cell.setCellValue((Integer)value);
				}
				
				if(value instanceof Boolean) {
					cell.setCellValue((Boolean)value);
				}
				
				
			}
			
		}
		File file = new File("C:\\Users\\Annangi\\eclipse-workspace\\practiceMaven\\src\\test\\resources\\FbLogin.xlsx");
		FileOutputStream fOutputStream = new FileOutputStream(file);
		workbook.write(fOutputStream);
		fOutputStream.close();
		workbook.close();
		
		
	}
	

}
