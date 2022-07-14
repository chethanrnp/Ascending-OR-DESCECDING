package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class ContactPage extends WebDriverUtility{

//Declaration
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement tbfirstName;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement tblastName;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement lkpImgOrg;
	
	@FindBy(xpath = "//input[@name='button']")
	private WebElement btnSave;
//initilization
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization

    public void enterFirstName(String firstName) {
		this.tbfirstName.sendKeys(firstName);
	}

   public void enterLastName(String lastName) {
		this.tblastName.sendKeys(lastName);
	}
	
   
   public void clickSave() {
	this.btnSave.click();
}

public void clickContactLkpImg(WebDriver driver) {
	this.lkpImgOrg.click();
	switchWindow(driver);
}
}
