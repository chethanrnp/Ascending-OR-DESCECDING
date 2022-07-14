package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CampaignPage extends WebDriverUtility{

	 //Declaration
	
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement tbCampaignName;
	
	@FindBy(xpath = "//input[@name='assigntype']/..//input[@value='T']")
	private WebElement radioBtnGroup;
	
	@FindBy(xpath = "//select[@name='expectedresponse']")
	private WebElement drpExpResponce;
	
	@FindBy(xpath = "//input[@name='closingdate']")
	private WebElement tbExpDate;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']/..//input[@class='crmButton small save']")
	private WebElement btnSave;
	
	//initilization
	
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//utilization
	public void enterCampaignName(String name) {
		this.tbCampaignName.sendKeys(name);
	}

	public void clkRdBtnGroup() {
		this.radioBtnGroup.click();
	}

	public void clickSave() {
		this.btnSave.click();
	}
	
	public void drpExpResponce(String expResponce) {
		selectDropDownByVtext(drpExpResponce, expResponce);
		
	}
	
	public void dateExp(WebDriver driver) {
		tbExpDate.sendKeys("1993/09/20");
	}
	
}
