package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
//Declaration
	 @FindBy(xpath = "//span[@class='dvHeaderText']")
	 private WebElement lnkCampaignInfo;
	
	 //initilization
	 public CampaignInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 //Utilization

	public WebElement LnkCampaignInfo() {
		return lnkCampaignInfo;
	}
	
	 
}
