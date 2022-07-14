package com.crmTestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.IPathConstants;

public class DataproviderTest {

	 @Test(dataProvider = "bookTicketTest")
	 public void bookTicketTest(String src,String dst) {
		 System.out.println("from"+src+"to"+dst);
	 }
	 
	 @DataProvider
	 public Object[][] bookTicketTest(){
		 ExcelUtility elib=new ExcelUtility();
		 Object[][] ob=new Object[3][2];
		 ob[0][0]=elib.getDataFromExcelSheet(IPathConstants.excelPath, "DataProvider", 1, 1);
		 ob[0][1]=elib.getDataFromExcelSheet(IPathConstants.excelPath, "DataProvider", 1, 2);
		 ob[1][0]=elib.getDataFromExcelSheet(IPathConstants.excelPath, "DataProvider", 2, 1);
		 ob[1][1]=elib.getDataFromExcelSheet(IPathConstants.excelPath, "DataProvider", 2, 2);
		 ob[2][0]=elib.getDataFromExcelSheet(IPathConstants.excelPath, "DataProvider", 3, 1);
		 ob[2][1]=elib.getDataFromExcelSheet(IPathConstants.excelPath, "DataProvider", 3, 2);
		 return ob;
	 }
}
