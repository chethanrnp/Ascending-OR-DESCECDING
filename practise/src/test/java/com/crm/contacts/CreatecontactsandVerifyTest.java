package com.crm.contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.objectRepositry.ContactPage;
import com.crm.objectRepositry.CreateCampaignPage;
import com.crm.objectRepositry.CreateContactspage;
import com.crm.objectRepositry.Homepage;
import com.crm.objectRepositry.LoginPage;
import com.crm.objectRepositry.contactInfoPage;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.IPathConstants;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecontactsandVerifyTest extends BaseClass{

	 @Test
	 public void CreatecontactsandVerifyTest() {
		 
			
		   ExcelUtility elib = new ExcelUtility();
			JavaUtility jlib = new JavaUtility();
	
			//fetches data from excel
			String Firstname = elib.getDataFromExcelSheet(IPathConstants.excelPath, "contacts", 1, 2)+jlib.getRandomNumber();
			String lastname = elib.getDataFromExcelSheet(IPathConstants.excelPath, "contacts", 1, 4)+jlib.getRandomNumber();
	
			    //click on contacts
			    Homepage homepage =new Homepage(driver);
			    homepage.clickContacts();
			    //click on create conatct
			    CreateContactspage conatct=new CreateContactspage(driver);
			    conatct.clickCreatContact();
			    ContactPage create=new ContactPage(driver);
			    //enter the first name
			    create.enterFirstName(Firstname);
			    //eneter the last name
			    create.enterLastName(lastname);
			    //click on save
			    create.clickSave();
			    //verify whether contacts is created
			    contactInfoPage info =new contactInfoPage(driver);
			    WebElement element = info.getContactInfoLnk();
			    Assert.assertTrue(element.isDisplayed());
			 /*   if(element.isDisplayed()) {
			    	System.out.println("contacts is created");
			    }
			    else
			    	System.out.println("contacts is not created");*/
			    
	}
}
