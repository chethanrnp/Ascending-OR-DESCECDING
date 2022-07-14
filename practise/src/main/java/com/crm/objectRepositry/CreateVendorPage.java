package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {

	 //declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement lkpImgVendor;
	
	//initilization
	public CreateVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	
	//utilization
	public void clickLkpImgVendor() {
		this.lkpImgVendor.click();
	}
}
