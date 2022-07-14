package vtiger.vendor.product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class practise {

	 public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		ExcelUtility elib=new ExcelUtility();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(elib.getDataFromExcelSheet(".\\src\\test\\resources\\FLIPKART.xlsx", "Organisation", 1, 2));
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
			 book.getSheet("Organisation").createRow(j).createCell(0).setCellValue(names);
			 book.getSheet("Organisation").createRow(j).createCell(1).setCellValue(prices);
			 System.out.println(names);
			// FileOutputStream o=new FileOutputStream("D:\\Selenium-workspace2\\com.com.SDET35\\src\\test\\resources\\FLIPKART.xlsx");
			  // book.write(o);
			 
		}
		   FileOutputStream o=new FileOutputStream("D:\\Selenium-workspace2\\com.com.SDET35\\src\\test\\resources\\FLIPKART.xlsx");
		   book.write(o);
		   
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
