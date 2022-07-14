package com.crm.vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_practise {

	 public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/HP/Desktop/frame_1.html");
		//switches to child window
		driver.switchTo().frame(0);
		//to write on child window
		driver.findElement(By.id("t2")).sendKeys("chethan");
		//to bring control to parent window
	//	driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t1")).sendKeys("chethan");
	}
}
