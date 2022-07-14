package com.crm.vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipKart_EntryData_toExcel {

	 public static void main(String[] args) throws Throwable {
			WebDriverManager.chromedriver().setup();
		    WebDriver	driver=new ChromeDriver();
		    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		    WebDriverWait wait=new WebDriverWait(driver, 30);
		    Thread.sleep(3000);
		    driver.get("https://www.flipkart.com/");
		    driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.manage().deleteAllCookies();
		    driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		  //  driver.findElement(By.xpath("//input[@name='q']")).sendKeys(getData(".\\src\\test\\resources\\FLIPKART.xlsx","Sheet1", 1, 0));
		    driver.findElement(By.xpath("//input[@name='q']")).sendKeys("woodland");
		    driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		    driver.navigate().refresh();
		    Thread.sleep(7000);
		    List<WebElement> name = driver.findElements(By.xpath("//a[@class='IRpwTa']"));
		    List<WebElement> price = driver.findElements(By.xpath("//div[@class='_2WkVRV']/../..//div[@class='_30jeq3']"));
		    FileInputStream f=new FileInputStream("D:\\Selenium-workspace2\\com.com.SDET35\\src\\test\\resources\\FLIPKART.xlsx");
		   Workbook book = WorkbookFactory.create(f);
		   for (int i=0, j = 5; i < name.size(); i++,j++) {
			String names = name.get(i).getText();
			 String prices = price.get(i).getText();
			 book.getSheet("Sheet1").createRow(j).createCell(0).setCellValue(names);
			 book.getSheet("Sheet1").createRow(j).createCell(1).setCellValue(prices);
			 System.out.println(names);
			 
		}
		   FileOutputStream o=new FileOutputStream("D:\\Selenium-workspace2\\com.com.SDET35\\src\\test\\resources\\FLIPKART.xlsx");
		   book.write(o);
		   book.close();
	}
	 public static String getData(String path,String sheet,int r,int c) {
		 String d=null;
		try {
			 FileInputStream f=new FileInputStream(path);
			Workbook book = WorkbookFactory.create(f);
			d=book.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
		} catch (Exception e) {
			
		}
		return d;
	}
}
