package vtiger.vendor.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Order_ObjectIn_ArrayList {

	 public static void main(String[] args) {
			WebDriver driver =null;
			 ExcelUtility elib = new ExcelUtility();
				FileUtility flib = new FileUtility();
				JavaUtility jlib = new JavaUtility();
			
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
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[text()='Organizations']")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			WebElement element = driver.findElement(By.xpath("//select[@name='industry']"));
			Select s=new Select(element);
			List<WebElement> dropDown = s.getOptions();
			System.out.println(dropDown.size());
			ArrayList<String> a=new ArrayList<String>();
			for(WebElement lv:dropDown) {
				String text = lv.getText();
				a.add(text);
			}
			//in alphabetic order
			//Collections.sort(a);
			//in reverse order
			Collections.sort(a,Collections.reverseOrder());
			for(String lv1:a) {
			System.out.println(lv1);	
			}
	}
}
