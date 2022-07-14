package vtiger.vendor.product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reverse_OrderOf_TreeSet {

	 public static void main(String[] args) throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[text()='Products']")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	WebElement dropDown = driver.findElement(By.xpath("//select[@name='glacct']"));
	Select s=new Select(dropDown);
	List<WebElement> options = s.getOptions();
	System.out.println(options.size());
	TreeSet<String> t=new TreeSet(Collections.reverseOrder());
	for(WebElement lv:options) {
		String text = lv.getText();
		t.add(text);
	}

	for(String lv1:t) {
		System.out.println(lv1);
	}
	}
}
