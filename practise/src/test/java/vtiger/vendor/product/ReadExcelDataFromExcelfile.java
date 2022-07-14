package vtiger.vendor.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadExcelDataFromExcelfile {

	 public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		//fetches the property file
		 ExcelUtility elib = new ExcelUtility();
			FileUtility flib = new FileUtility();
			JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
			String username = flib.getPropertyKeyValue(".\\src\\test\\resources\\data.properties.txt", "usn");
			String password = flib.getPropertyKeyValue(".\\src\\test\\resources\\data.properties.txt", "pwd");
			String url = flib.getPropertyKeyValue(".\\src\\test\\resources\\data.properties.txt", "url");
			String browser = flib.getPropertyKeyValue(".\\src\\test\\resources\\data.properties.txt","browser");		
		FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\testScript.xlsx");
		Workbook book = WorkbookFactory.create(fs);
		String d = book.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		//creats diffrent 
		Random random=new Random();
		int randomNum = random.nextInt(100);
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[@name='Vendors']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys("arya");
		driver.findElement(By.xpath("//input[@name='button' ]")).click();
		WebElement element2 = driver.findElement(By.xpath("//span[text()='arya -  Vendor Information']"));
		if(element2.isDisplayed()) {
			System.out.println("vendor is created _1");
		}
		else {
			System.out.println("vendor is not created");
		}
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys("test_1");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		String mainwindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		swictch(driver);
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(d+randomNum);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[@id='1']")).click();
		Thread.sleep(3000);
		for(String lv:allWindow) {
			driver.switchTo().window(lv);
			String text=driver.getTitle();
			if(text.contains("Administrator - Products - vtiger CRM 5 - Commercial Open Source CRM")) {
				break;
			}
		}
	    driver.findElement(By.xpath("//input[@name='button']")).click();
	    WebElement element3 = driver.findElement(By.xpath("//span[text()='test_1 -  Product Information']"));
		if(element3.isDisplayed()) {
			System.out.println("vendor is created _2");
		}
		else {
			System.out.println("vendor is not created");
		}
		
		WebElement element4 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		a.moveToElement(element4).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	 public static void swictch(WebDriver driver) {
			String mainwindow = driver.getWindowHandle();
			Set<String> allWindow = driver.getWindowHandles();
			for(String lv:allWindow)  {
			if(!lv.equals(mainwindow)) 
					driver.switchTo().window(lv);
			}
		
		
		}
}
