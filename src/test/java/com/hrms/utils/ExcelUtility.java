package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtility {
	private static Workbook book; // no one can access private data
	private static Sheet sheet;
	
	public static void openExcel(String filePath, String sheetName) {// make it dynamic
		
	//1. 	this is for open and reach to excel file. kapayi acmak
		try {
			FileInputStream fis= new FileInputStream(filePath);
			book= new XSSFWorkbook(fis); // new excel
		    sheet= book.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();// will work in any class and than throw an exception
		} catch (IOException e) {// // clause select
			
			e.printStackTrace();
		}
		
	}
	//2. why re do / re usability. prevents hard code.
		public static int rowCount() { // what is row count (1-3). need to know when is the end and when is the start.return method
		return sheet.getPhysicalNumberOfRows();
		
	}
		public static int colCount() {// how many cells/column. // to get total cell/col number
			return sheet.getRow(0).getLastCellNum();
		}
		
		
	//3. by now you know when to get to excel and count row and column. by now you have the backbone. skeleton
		
	 public static String getCellData(int rowIndex, int colIndex) { // to get specific data/cell
	 return sheet.getRow(rowIndex).getCell(colIndex).toString();
	
	
		}
	
	
	 // 4. this is a special method for dataprovider or data provide.
	
		public static Object [][] excelToArray(String filePath, String sheetName){
			
			openExcel(filePath,sheetName);
			Object [][] data = new Object[rowCount()-1][colCount()];
			for (int i = 1; i <rowCount() ; i++) {//eliminate header
				for (int j = 0; j < colCount(); j++) {
					data[i-1][j]= getCellData(i, j);
				}
				
				
			}
			
			return data;
		}
	
	 }
