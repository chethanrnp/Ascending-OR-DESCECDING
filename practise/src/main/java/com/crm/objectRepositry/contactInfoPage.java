package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactInfoPage {

	 //Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactInfoLnk;
	
	//initilization
	public contactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement ContactInfoLnk() {
		return contactInfoLnk;
	}

	public WebElement getContactInfoLnk() {
		return contactInfoLnk;
	}
	
	
	
}
