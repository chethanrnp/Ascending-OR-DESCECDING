package vtiger.vendor.product;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class p1 {

	 public static void main(String[] args) throws Throwable {
			WebDriver driver =null;
			 ExcelUtility elib = new ExcelUtility();
				FileUtility flib = new FileUtility();
				JavaUtility jlib = new JavaUtility();
			     WebDriverUtility wlib=new WebDriverUtility();
				String username = flib.getPropertyKeyValue(".\\src\\test\\resources\\data.properties.txt", "usn");
				String password = flib.getPropertyKeyValue(".\\src\\test\\resources\\data.properties.txt", "pwd");
				String url = flib.getPropertyKeyValue(".\\src\\test\\resources\\data.properties.txt", "url");
				String browser = flib.getPropertyKeyValue(".\\src\\test\\resources\\data.properties.txt","browser");		
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
			driver.get(url);
			driver.manage().window().maximize();
			wlib.waitForPageToLoad(driver);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(elib.getDataFromExcelSheet(".\\src\\test\\resources\\testScript.xlsx", "Product", 1, 2)+jlib.getRandomNumber());
	    WebElement selectbox = driver.findElement(By.xpath("//select[@name='manufacturer']"));
	  //  Select s=new Select(selectbox);
	   // s.selectByValue("AltvetPet Inc.");
	    wlib.selectDropDownByValue(selectbox, "AltvetPet Inc.");
	    driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@id='files_list']")).click();
	    fileUpload("D:\\Selenium-workspace2\\com.com.SDET35\\upload\\abhiResume.docx");
	    driver.findElement(By.xpath("(//input[contains(@class,'crmbutton ')])[4]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[text()='Products']")).click();
	   WebElement element = driver.findElement(By.xpath("//a[@title='Products'][1]"));
	   if(element.isDisplayed()) {
		   System.out.println("file is  created");
	   }
	   else {
		   System.out.println("file is not created");
	   }
	   driver.findElement(By.xpath("//td[@align='center'][4]")).click();
	   driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();  
	   driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("KIA");  
	}
	 
	 public static void fileUpload(String path) throws Throwable {
		StringSelection s=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
