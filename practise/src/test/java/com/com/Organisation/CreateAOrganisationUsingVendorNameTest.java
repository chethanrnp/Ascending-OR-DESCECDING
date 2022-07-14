package com.com.Organisation;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.objectRepositry.Homepage;
import com.crm.objectRepositry.LoginPage;
import com.crm.objectRepositry.OrganisationInfopage;
import com.crm.objectRepositry.ContactPage;
import com.crm.objectRepositry.CreateContactspage;
import com.crm.objectRepositry.CreateOrganisationPage;
import com.crm.objectRepositry.OrganisationPage;
import com.crm.objectRepositry.contactLkpImgPage;
import com.crm.objectRepositry.contactInfoPage;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.IPathConstants;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(genericUtilities.myListner.class)
public class CreateAOrganisationUsingVendorNameTest extends BaseClass{
     @Test()
 	 public void CreateAOrganisationUsingVendorNameTest(){
		 
		    ExcelUtility elib = new ExcelUtility();
			JavaUtility jlib = new JavaUtility();
		
			//fetches data from excel
			String OrgNmae = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Sheet1",4, 2)+jlib.getRandomNumber();
			 String industry = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Organisation", 3, 1);
			String type = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Organisation", 7,2 );
			String ContFirstName = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Sheet1", 1, 1)+jlib.getRandomNumber();
			String ContLastName = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Sheet1", 1, 2)+jlib.getRandomNumber();
		
		    //click on Organisation
		    Homepage homepage =new Homepage(driver);
		    homepage.clickOrganisation();
		    //click on new create organisation
		   CreateOrganisationPage createOrg=new CreateOrganisationPage(driver);
		   createOrg.clickCreateOrganization();
		    OrganisationPage orgfill=new OrganisationPage(driver);
		    //enters the organisation name
		    orgfill.enterOrgname(OrgNmae);
		    //select dropdown from industry
		    orgfill.selectIndustry(industry);
		    //select drop down from tye
		    orgfill.selectType(type);
		    //click on save
		    orgfill.ClickSave();
		    //verify organisation is created
	          OrganisationInfopage info=new OrganisationInfopage(driver);
	          WebElement ele = info.getOrgInfoLnk();
	          assertTrue(ele.isDisplayed());
		 /*   if(ele.isDisplayed()) {
		    	System.out.println("organisation is created _1");
		    }
		    else {
                System.out.println("organisation is not created");
		    }*/
		    //click on conatct
		   homepage.clickContacts();
		    CreateContactspage contact=new CreateContactspage(driver);
		    //click on create contact
		    contact.clickCreatContact();
		    ContactPage cont=new ContactPage(driver);
		    //enter contact first name
		    cont.enterFirstName(ContFirstName);
		    //enter the contact last name
		    cont.enterLastName(ContLastName);
		    //click on contact luckUp Image
		    cont.clickContactLkpImg(driver);
		    contactLkpImgPage cntHedTxt=new contactLkpImgPage(driver);
		    cntHedTxt.conatctheaderTxt(driver, "contatcs");
		   //click on save 
		    cont.clickSave();
		    //verify conatct is created 
           contactInfoPage cntinfo=new contactInfoPage(driver);
           String contats  =cntinfo.ContactInfoLnk().getText();
           assertTrue(contats.contains("Contact Information"));
		/*   if(contats.contains("Contact Information")) {
		    	System.out.println("contacts is created _1");
		    }
		    else {
              System.out.println("contacts is not created");
		    }*/
		}
		
	}

