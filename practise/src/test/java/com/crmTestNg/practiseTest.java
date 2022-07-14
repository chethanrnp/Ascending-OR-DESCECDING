package com.crmTestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.objectRepositry.LoginPage;

import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.IPathConstants;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class practiseTest {

	@Test(dataProvider = "loginPageData")
	public void loginPageTest(String usn,String pwd) throws Throwable {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wlib=new WebDriverUtility();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        LoginPage lpage=new LoginPage(driver);
        lpage.loginPage(usn, pwd);
        wlib.takeScreenShot(driver, "loginpage");
		driver.close();
		}
	
	@DataProvider
	public Object[][] loginPageData() {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		Object[][] ob=new Object[2][2];
		ob[0][0]=flib.getPropertyKeyValue(IPathConstants.filePath,"usn");
		ob[0][1]=flib.getPropertyKeyValue(IPathConstants.filePath,"pwd");
		ob[1][0]=elib.getDataFromExcelSheet(IPathConstants.excelPath, "DataProvider",1 ,1 );
		ob[1][1]=elib.getDataFromExcelSheet(IPathConstants.excelPath, "DataProvider", 1,2 );
		return ob;
	}
}
