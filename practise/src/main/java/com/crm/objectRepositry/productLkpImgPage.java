package com.crm.objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productLkpImgPage {

//initilization
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement tbSearch;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement btnSearch;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement lnkVendorSearch;

//initilization
public productLkpImgPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

 	//utilization
 public void searchVendor(String Vendorname) {
	 this.btnSearch.sendKeys(Vendorname);
	 this.btnSearch.click();
	 this.lnkVendorSearch.click();
 }
}
