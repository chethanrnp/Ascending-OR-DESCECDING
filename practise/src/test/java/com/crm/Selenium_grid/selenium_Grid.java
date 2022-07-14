package com.crm.Selenium_grid;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class selenium_Grid {
	@Test
	public  void seleniumGrid() throws Throwable {
		URL url=new URL("http://192.168.43.33:7777/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("https://www.flipkart.com/");
		//http://192.168.43.33:4444/wd/hub
	}
}