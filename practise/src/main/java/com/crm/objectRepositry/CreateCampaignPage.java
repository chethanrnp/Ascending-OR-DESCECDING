package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	//declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement lkpImgCampaign;
	
	//initilization
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
	//utlization

	public void clickCreateCampaign() {
      this.lkpImgCampaign.click();
	}
	
}