package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {

	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement lnkInfoVender;
	
	//Initilastion
	public VendorInfoPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

		//utilization
	public WebElement lnkInfoVender() {
		return lnkInfoVender;
	}
	

}
