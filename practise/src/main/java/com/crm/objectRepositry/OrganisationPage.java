package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class OrganisationPage extends WebDriverUtility{

	//Declaration
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement tbOrgNmae;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement selectIndustry;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement selectType;
	
	@FindBy(xpath = "//input[@name='button']")
	private WebElement btnSave;
	
	@FindBy(xpath ="//input[@name='notify_owner']" )
	private WebElement checkBxNotifyOner;
	
	@FindBy(xpath ="//input[@name='cpy']" )
	private WebElement radioBtnShipAdrs;
	
	@FindBy(xpath ="//input[@onclick='return copyAddressRight(EditView)']" )
	private WebElement radioBtnBilAdrs;
	
	@FindBy(xpath ="//textarea[@name='description']" )
	private WebElement tbDiscription;
	//initilization 
		  public OrganisationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	//utilization
   public void selectType(String type) {
	selectDropDownByVtext(selectType,type );
}
   
   public void selectIndustry(String industry) {
	selectDropDownByVtext(selectIndustry, industry);
}
public void enterOrgname(String OrgName ) {
	this.tbOrgNmae.sendKeys(OrgName);
}
public void ClickSave() {
	this.btnSave.click();
}


public void ClickNotifyOner() {
	this.checkBxNotifyOner.click();
}
public void clickNotifyRef(WebDriver driver) {
	this.checkBxNotifyOner.click();
	driver.navigate().refresh();
}
 
public void enterDiscription() {
	this.tbDiscription.sendKeys("[cam**]abc-Campaign Information Update Today");
}
public void ClickSipAdders() {
	this.radioBtnShipAdrs.click();
}
public void clickShipAdrsRef(WebDriver driver) {
	this.radioBtnBilAdrs.click();
	driver.navigate().refresh();
}

public void radioBtnBilAdrs(WebDriver driver) {
	this.radioBtnBilAdrs.click();
	driver.navigate().refresh();
}
public WebElement getCheckBxNotifyOner() {
	return checkBxNotifyOner;
}
public WebElement getRadioBtnShipAdrs() {
	return radioBtnShipAdrs;
}
public WebElement getRadioBtnBilAdrs() {
	return radioBtnBilAdrs;
}


}
