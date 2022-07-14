package com.crm.objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productInfoPage {

	//declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement lnkProductInfo;
	
	//initilization
	public productInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

		
	//utilization
	public WebElement getLnkProductInfo() {
		return lnkProductInfo;
	}

}


