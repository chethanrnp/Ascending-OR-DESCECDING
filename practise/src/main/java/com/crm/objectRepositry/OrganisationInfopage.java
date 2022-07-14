package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfopage {

//DEclaration
 @FindBy(xpath = "//span[@class='dvHeaderText']")
 private WebElement orgInfoLnk;
 
 //intilization
 public OrganisationInfopage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getOrgInfoLnk() {
	return orgInfoLnk;
}
 
 
}
