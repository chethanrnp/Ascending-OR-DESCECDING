package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {

	 //declaration
	@FindBy(xpath = "//input[@name='vendorname']")
	private WebElement tbVendorName;
	
	@FindBy(xpath = "//input[@name='button' ]")
	private WebElement btnSave;
	
	//initization
	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
	//utilization
	public WebElement tbVendorName() {
		return tbVendorName;
	}

	public WebElement btnSave() {
		return btnSave;
	}
}
