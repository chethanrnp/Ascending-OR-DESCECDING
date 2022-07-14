package com.com.Organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.objectRepositry.ContactPage;
import com.crm.objectRepositry.CreateContactspage;
import com.crm.objectRepositry.CreateOrganisationPage;
import com.crm.objectRepositry.Homepage;
import com.crm.objectRepositry.LoginPage;
import com.crm.objectRepositry.OrganisationInfopage;
import com.crm.objectRepositry.OrganisationPage;
import com.crm.objectRepositry.contactInfoPage;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.IPathConstants;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationUsingContactTest extends BaseClass{

	 @Test
	 public void CreateOrganisationUsingContactTest() {
			
		   ExcelUtility elib = new ExcelUtility();
			JavaUtility jlib = new JavaUtility();
			//fetches data from excel
			String OrgNmae = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Sheet1",4, 2)+jlib.getRandomNumber();
			String Firstname = elib.getDataFromExcelSheet(IPathConstants.excelPath, "contacts", 1, 2)+jlib.getRandomNumber();
			String lastname = elib.getDataFromExcelSheet(IPathConstants.excelPath, "contacts", 1, 4)+jlib.getRandomNumber();
		
			    //click on Organisation
			    Homepage homepage =new Homepage(driver);
			    homepage.clickOrganisation();
			    //click on new create organisation
			   CreateOrganisationPage createOrg=new CreateOrganisationPage(driver);
			   createOrg.clickCreateOrganization();
			    OrganisationPage orgfill=new OrganisationPage(driver);
			    //enters the organisation name
			    orgfill.enterOrgname(OrgNmae);
			    //click on save
			    orgfill.ClickSave();
			    //verify organisation is created
		          OrganisationInfopage info=new OrganisationInfopage(driver);
		          WebElement ele = info.getOrgInfoLnk();
		          Assert.assertTrue(ele.isDisplayed());
			/*    if(ele.isDisplayed()) {
			    	System.out.println("organisation is created _1");
			    }
			    else {
	                System.out.println("organisation is not created");
			    }*/
			    //click on conatct
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
			    contactInfoPage inf =new contactInfoPage(driver);
			    WebElement element = inf.getContactInfoLnk();
			    Assert.assertTrue(element.isDisplayed());
			/*    if(element.isDisplayed()) {
			    	System.out.println("contacts is created");
			    }
			    else
			    	System.out.println("contacts is not created");*/
	}
}
