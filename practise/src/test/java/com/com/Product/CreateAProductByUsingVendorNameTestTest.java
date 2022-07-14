package com.com.Product;

import java.awt.Desktop.Action;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.objectRepositry.CreateVendorPage;
import com.crm.objectRepositry.Homepage;
import com.crm.objectRepositry.LoginPage;
import com.crm.objectRepositry.VendorInfoPage;
import com.crm.objectRepositry.VendorPage;
import com.crm.objectRepositry.createProductpage;
import com.crm.objectRepositry.productInfoPage;
import com.crm.objectRepositry.productLkpImgPage;
import com.crm.objectRepositry.productPage;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.IPathConstants;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAProductByUsingVendorNameTestTest extends BaseClass{

	 @Test//(retryAnalyzer = genericUtilities.RetryAnalyserImptn.class)
	 public void CreateAProductByUsingVendorNameTestTest() throws Throwable{
		 
		     ExcelUtility elib = new ExcelUtility();
			JavaUtility jlib = new JavaUtility();
		 	
    //fetch the data from excel
			String vName = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Vendors", 1, 1)+jlib.getRandomNumber();
			String productName = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Vendors", 1, 2)+jlib.getRandomNumber();
			String search = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Organisation", 1, 7)+jlib.getRandomNumber();
			
			Homepage home=new Homepage(driver);
			home.clickVendor(driver);
			CreateVendorPage crt=new CreateVendorPage(driver);
			crt.clickLkpImgVendor();
			VendorPage vend=new VendorPage(driver);
			vend.tbVendorName().sendKeys(vName);
			vend.btnSave().click();
			VendorInfoPage info=new VendorInfoPage(driver);
			WebElement element2 = info.lnkInfoVender();
	//Assert.assertTrue(element2.isDisplayed());
		/*if(element2.isDisplayed()) {
			System.out.println("vendor is created _1");
		}
		else {
			System.out.println("vendor is not created");
		}*/
	//Thread.sleep(3000);
		home.clickProduct();
		createProductpage product=new createProductpage(driver);
		product.clickCreatProduct();
		productPage page=new productPage(driver);
		page.enterProName(productName);
		page.ClickVendorLkpImp();
		wLib.switchWindow(driver);
	//	driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(elib.getDataFromExcelSheet("./src\\test\\resources\\FLIPKART.xlsx", "Organisation", 1, 0)+jlib.getRandomNumber());
	//	driver.findElement(By.xpath("//img[@title='Select']")).click();
	//	wlib.switchToWindow(driver, "Vendors&action");
	//	driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(elib.getDataFromExcelSheet("src\\test\\resources\\FLIPKART.xlsx", "Organisation", 1, 1)+jlib.getRandomNumber());
	//	driver.findElement(By.xpath("//input[@name='search']")).click();
	//	driver.findElement(By.xpath("//a[@id='1']")).click();
		productLkpImgPage pLkp=new productLkpImgPage(driver);
		pLkp.searchVendor(search);
	//	wlib.switchToWindow(driver, "Products&action");
		wLib.switchWindow(driver);
	
	  //  driver.findElement(By.xpath("//input[@name='button']")).click();
		productInfoPage pInfo=new productInfoPage(driver);
		WebElement element3=pInfo.getLnkProductInfo();
		Assert.assertTrue(element3.isDisplayed());
	 //   WebElement element3 = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	/*	if(element3.isDisplayed()) {
			System.out.println("vendor is created _2");
		}
		else {
			System.out.println("vendor is not created");
		}*/
		
			}

	 }
