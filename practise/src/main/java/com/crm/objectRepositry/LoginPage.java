package com.crm.objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//Declaration
	 @FindBy (xpath="//input[@name='user_name']")
	 private WebElement usernameTb;
	 
	 @FindBy (xpath="//input[@name='user_password']")
	 private WebElement passwordTb;
	 
	 @FindBy (id="submitButton")
	 private WebElement submitBtn;
	 //intilization
	 public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilization 
	public void loginPage(String usn,String pwd) {
		this.usernameTb.sendKeys(usn);
		this.passwordTb.sendKeys(pwd);
		this.submitBtn.click();
	}


	
}
