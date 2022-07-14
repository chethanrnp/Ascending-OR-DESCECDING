package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactspage {

	//Declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement lkpImgCreateContact;
	
	//initilization
	public CreateContactspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public void clickCreatContact() {
		this.lkpImgCreateContact.click();
	}
	

	
}
