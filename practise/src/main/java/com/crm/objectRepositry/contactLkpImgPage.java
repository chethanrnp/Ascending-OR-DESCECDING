package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class contactLkpImgPage extends WebDriverUtility{

	//Declaration
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchTb;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchLnk;
	
	@FindBy(xpath = "//a[contains(text(),'TYSS')]")
	private WebElement orgNameLnk;
	
	//inilization
	public contactLkpImgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void conatctheaderTxt(WebDriver driver,String Search) {
		switchWindow(driver);
		this.searchTb.sendKeys(Search);
		this.searchLnk.click();
		this.orgNameLnk.click();
	//	switchToWindow(driver, "EditView&return_action");
		switchWindow(driver);
	}
}
