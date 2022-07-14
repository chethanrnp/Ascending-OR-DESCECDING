package jdbc.connection;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ToCreateProjectInDB {

	 public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("woodland");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("kaleesh");
		WebElement element = driver.findElement(By.xpath("//label[text()='Project Status ']/..//select[@name='status']"));
		Select s=new Select(element);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
	}
}
