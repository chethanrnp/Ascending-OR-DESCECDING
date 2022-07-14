package com.com.Organisation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.objectRepositry.CreateOrganisationPage;
import com.crm.objectRepositry.Homepage;
import com.crm.objectRepositry.LoginPage;
import com.crm.objectRepositry.OrganisationInfopage;
import com.crm.objectRepositry.OrganisationPage;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.IPathConstants;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationAndverifyTest extends BaseClass{
	
       @Test
	 public void CreateOrganisationAndverifyTest() {
		 
			
		   ExcelUtility elib = new ExcelUtility();
			JavaUtility jlib = new JavaUtility();
		
					//fetches data from excel
			String OrgNmae = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Sheet1",4, 2)+jlib.getRandomNumber();
			
			
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
			  /*  if(ele.isDisplayed()) {
			    	System.out.println("organisation is created _1");
			    }
			    else {
	                System.out.println("organisation is not created");
			    }*/
			    //click on organization
			    homepage.clickOrganisation();
			    boolean rs=false;
			  List<WebElement> orgName = driver.findElements(By.xpath("//a[text()='Organization Name']/../../..//td[3]//a[@title='Organizations']"));
			  for(WebElement lv:orgName) {
				  String name=lv.getText();
				  if(name.contains(OrgNmae)) {
					  System.out.println("created");
					  rs=true;
					  break;
				  }
				 
				 
			  }
			  if(rs=false)
			  {
				  System.out.println("not created");
			  }
			 	}
}
