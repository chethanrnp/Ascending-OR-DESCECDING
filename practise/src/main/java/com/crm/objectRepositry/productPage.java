package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage {

	//Declaration
		@FindBy(xpath = "//input[@class='detailedViewTextBox']")
		private WebElement tbProductName;
		
		@FindBy(xpath = "//img[@title='Select']")
		private WebElement lkpImgProduct;
		
		@FindBy(xpath = "//input[@name='button']")
		private WebElement btnSave;
		
		//initilization
		public productPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public void enterProName(String productname) {
			this.tbProductName.sendKeys(productname);
		}
		
		public void ClickVendorLkpImp() {
			this.lkpImgProduct.click();
		}
		
		public void ClickSave() {
			this.btnSave.click();
		}
}
