package jdbc.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToCreateProjectUsingExcel_Properties {

	 public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\JDBCDATA.Properties");
		Properties prop=new Properties();
		prop.load(f);
		String username = prop.getProperty("usn");
		String password = prop.getProperty("pwd");
		String url = prop.getProperty("url");
		String Browser = prop.getProperty("browser");
		if(Browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.id("usernmae")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(getData(".\\src\\test\\resources\\FLIPKART.xlsx", "Sheet1", 3, 0));
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys(getData(".\\src\\test\\resources\\FLIPKART.xlsx", "Sheet1", 3, 1));
		WebElement element = driver.findElement(By.xpath("//label[text()='Project Status ']/..//select[@name='status']"));
		Select s=new Select(element);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//th[text()='ProjectName']/../../..//td[2]"));
		for(WebElement lv:ele) {
			String lv1=lv.getText();
			if(lv1.contains("yantra")) {
				System.out.println("project is created");
				break;
			}
			else {
			continue;
			}
		}
	}
	 public static String getData(String path,String sheet,int r,int c) {
		 String d=null;
		try {
			 FileInputStream f=new FileInputStream(path);
			Workbook book = WorkbookFactory.create(f);
			d=book.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
			Random r1=new Random();
			int rnumber = r1.nextInt(100);
			d=d+rnumber;
			
		} catch (Exception e) {
			
		}
		return d;
	}
}
