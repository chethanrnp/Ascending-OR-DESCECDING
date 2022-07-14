package com.crm.objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createProductpage {

	//declaration
	@FindBy(xpath = "//img[@title='Create Product...'")
	private WebElement lkpImgCreateProduct;
	
	//initilization
	public createProductpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void clickCreatProduct() {
		this.lkpImgCreateProduct.click();
	}
}
