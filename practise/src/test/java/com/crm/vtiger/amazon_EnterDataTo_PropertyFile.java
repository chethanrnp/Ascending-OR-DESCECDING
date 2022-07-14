package com.crm.vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazon_EnterDataTo_PropertyFile {

	 public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
	    WebDriver	driver=new ChromeDriver();
	    driver.get("https://www.amazon.in/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
	    driver.findElement(By.xpath("//a[text()=' Electronics ']")).click();
	    driver.findElement(By.xpath("//span[text()='Redmi']")).click();
	   String mobile = driver.findElement(By.xpath("//span[text()='Redmi Note 10 Pro (Dark Night, 6GB RAM, 128GB Storage) -120hz Super Amoled Display|64MPwith 5mp Super Tele-Macro | 33W Charger Included']")).getText();
	   // System.out.println(mobile);
	    FileInputStream read=new FileInputStream(".\\src\\test\\resources\\amazon.properties");
	   Properties prop=new Properties();
	   prop.setProperty("info", mobile);
	   FileOutputStream add=new FileOutputStream(".\\src\\test\\resources\\amazon.properties");
	   prop.store(add, mobile);
	   System.out.println(prop.getProperty("info"));
	   Thread.sleep(7000);
	   List<WebElement> discrp = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
	   List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']/../../../..//span[@class='a-price-whole']"));
	   TreeMap< Integer,String> t=new TreeMap();
	   for (int i = 0; i < discrp.size(); i++) {
		String d=discrp.get(i).getText();
		Integer prices=Integer.parseInt(price.get(i).getText().replace(",", ""));
		t.put(prices, d);
	}
	   for(Entry<Integer, String> lv:t.entrySet()) {
		   System.out.println(lv.getValue()+"="+lv.getKey());
	   }
	 }
}
