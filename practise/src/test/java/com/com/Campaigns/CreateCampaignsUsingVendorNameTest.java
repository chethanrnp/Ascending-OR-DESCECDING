package com.com.Campaigns;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.objectRepositry.CampaignInfoPage;
import com.crm.objectRepositry.CampaignPage;
import com.crm.objectRepositry.CreateCampaignPage;
import com.crm.objectRepositry.Homepage;
import com.crm.objectRepositry.LoginPage;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.IPathConstants;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignsUsingVendorNameTest extends BaseClass{
	@Test(groups = {"regressionTest"})
  public void CreateCampaignsUsingVendorNameTest(){
	 
	   ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
	 
        //fetches data from excel
		String campName = elib.getDataFromExcelSheet(IPathConstants.excelPath, "campigns", 1, 2)+jlib.getRandomNumber();
		String expResponc = elib.getDataFromExcelSheet(IPathConstants.excelPath, "campigns", 4, 7);
		//launches the browser
	
		//clisk on campaign
		Homepage home=new Homepage(driver);
		home.clickCampaign(driver);
		//click on create campaign
		CreateCampaignPage create=new CreateCampaignPage(driver);
		create.clickCreateCampaign();
		CampaignPage camp=new CampaignPage(driver);
		//enter the campaign name
		camp.enterCampaignName(campName);
		//select from responce dropdown
		camp.clkRdBtnGroup();
        camp.drpExpResponce(expResponc);
        //enters the dat
		camp.dateExp(driver);
		//click on save
		camp.clickSave();
		//verify whether campaign is created
		CampaignInfoPage infom=new CampaignInfoPage(driver);
		WebElement element2=infom.LnkCampaignInfo();
		assertTrue(element2.isDisplayed());
	/*	if(element2.isDisplayed()) {
			System.out.println("campaign is created");
		}
		else {
			System.out.println("campaign is not created");
		}*/
	
		}
}

