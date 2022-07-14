package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class Homepage extends WebDriverUtility{
// Declaration
	
	 @FindBy(xpath="//a[text()='Organizations']")
	 private WebElement lnkorganisation;
	 
	 @FindBy(xpath="//a[text()='Contacts']")
	 private WebElement lnkContacts;
	 
	 @FindBy(xpath="//a[text()='Products']")
	 private WebElement lnkProduct;
	 
	 @FindBy(xpath="//a[text()='Documents']")
	 private WebElement lnkDocuments;
	 
	 @FindBy(xpath="//a[text()='More']")
	 private WebElement lnkMore;
	 
	 @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	 private WebElement lnkAdministor;
	 
	 @FindBy(xpath="//a[text()='Sign Out']")
	 private WebElement lnkSignOut;
	 
	 @FindBy(xpath="//a[text()='Campaigns']")
	 private WebElement lnkCampaigns;
	 
	 @FindBy(xpath = "//a[@name='Vendors']")
	 private WebElement lnkVEndor;
	 
	//initilization 
	 public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 
	 
//utilization
	public void clickOrganisation() {
		this.lnkorganisation.click();
	}

	public void clickContacts() {
		this.lnkContacts.click();
	}

	public void clickProduct() {
		try {
			waitAndClick(lnkAdministor);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.lnkProduct.click();
	}

	public void clickDocument() {
	this.lnkDocuments.click();
	}

	public void clickMore() {
		this.lnkMore.click();
	}

	public void clickAdministor() {
		this.lnkAdministor.click();
	}

	public void clickSignOut() {
		this.lnkSignOut.click();
	}
	
	
	public void clickVendor(WebDriver driver) {
		mouseOverAnelement(driver, lnkMore);
		this.lnkVEndor.click();
	}
	
	public void clickOnLogOut(WebDriver driver) throws Throwable {
	//  waitForElementToBeVisible(driver, lnkAdministor);
	    Thread.sleep(3000);
		mouseOverAnelement(driver,lnkAdministor );
		this.lnkSignOut.click();
	}
	public void clickCampaign(WebDriver driver) {
		mouseOverAnelement(driver,lnkMore );
	    this.lnkCampaigns.click();
	}


}
