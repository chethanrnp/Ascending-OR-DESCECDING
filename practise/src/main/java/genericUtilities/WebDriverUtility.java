package genericUtilities;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * contains all reusable Actions of Webdriver
 * @author HP
 *
 */
public class WebDriverUtility {
/**
 * it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 	
 * @param driver
 */
public void waitForPageToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
/**
 * it Waits For Java Script element
 * @param driver
 */
public void waitForPageToLoadForJSEElement(WebDriver driver) {
	driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
}
/**
 * it Will Check for The GUI for polling time of 500ms
 * @param driver
 * @param element
 */
public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * waits for element to to be visible
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
}
/**
 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
 * @param driver
 * @param title
 */
public void waitForTitleContains(WebDriver driver,String title) {
	WebDriverWait wait=new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.titleContains(title));
}
/**
 * here we can change the polling time from default 500ms to any pooling time
 * @param driver
 * @param poolingTime
 * @param element
 */
public void wiatForElementToCustom (WebDriver driver,int poolingTime,WebElement element) {
	FluentWait wait=new FluentWait(driver);
	wait.pollingEvery(poolingTime, TimeUnit.SECONDS);
	wait.ignoring(Exception.class);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * here we are giving custom timtout
 * @param element
 * @throws Throwable
 */
public void waitAndClick(WebElement element) throws Throwable {
	int count=0;
	while(count<10) {
		try {
			element.click();
		} catch (Exception e) {
			Thread.sleep(1000);
			count++;
		}
		}
	}

/**
 * used to Switch to Any Window based on Window URL
 * @param driver
 * @param partialWindow
 */
public void switchToWindow(WebDriver driver,String partialWindow) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext()) {
		String wUrl = it.next();
		driver.switchTo().window(wUrl);
		String currentWindow = driver.getCurrentUrl();
		if(currentWindow.contains(partialWindow)) {
			break;
		}
	}
}
/**
 * used to switch to any window
 * @param driver
 */
public void switchWindow(WebDriver driver) {
	String mainWindow = driver.getWindowHandle();
	Set<String> allWindow = driver.getWindowHandles();
	for(String lv:allWindow) {
		driver.switchTo().window(lv);
		if(!lv.equals(mainWindow)) {
			break;
		}
	}
	driver.switchTo().window(mainWindow);
}
/**
 * used to Switch to Frame Window based on index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
/**
 * used to Switch to Frame Window based on id or name attribute
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,String id_attribute) {
	driver.switchTo().frame(id_attribute);
}
/**
 * switch from one frame to another frame by using absolute_path
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
/**
 * its used to switch back from one child frame to parent frame
 * @param driver
 * @param index
 */
public void switchTFrameMainWindow(WebDriver driver) {
	driver.switchTo().defaultContent();
}
/**
 * used to Switch to Alert Window & click on OK button
 * @param driver
 */
public void switchToAlertPopUpAndAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * used to Switch to Alert Window & click on Cancel button
 * @param driver
 */
public void switchToAlertPopUpAndDismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
/**
 * used to select the value from the dropDwon  based on index
 * @param element
 * @param index
 */
public void selectDropDownByIndex(WebElement element,int index) {
	Select select=new Select(element);
	select.selectByIndex(index);
}
/**
 * used to select the value from the dropDwon  based on value / option avlaible in GUI
 * @param element
 * @param index
 */
public void selectDropDownByValue(WebElement element,String value) {
	Select select=new Select(element);
	select.selectByValue(value);
}
/**
 * used to select the value from the dropDwon  based on value / option avlaible in GUI
 * @param element
 * @param index
 */
public void selectDropDownByVtext(WebElement element,String visible_Text) {
	Select select=new Select(element);
	select.selectByVisibleText(visible_Text);
}
/**
 * used to place mouse cursor on specified element
 * @param element
 * @param index
 */
public void mouseOverAnelement(WebDriver driver,WebElement element) {
	Actions action=new Actions(driver);
	action.moveToElement(element).perform();
}
/**
 * used to right click  on specified element
 * @param element
 * @param index
 */
public void rightClickOnElement(WebElement element,WebDriver driver) {
	Actions action=new Actions(driver);
	action.contextClick(element).perform();
}
/**
 * pass enter Key appertain in to Browser
 * @param element
 * @param index
 */
public void clickOnEnterButton(WebElement element,WebDriver driver) {
	Actions action=new Actions(driver);
	action.sendKeys(Keys.ENTER).perform();
}
/**
 * it is used to take screen shot
 * @param driver
 * @param screenShotName
 * @throws Throwable 
 */
public static void takeScreenShot(WebDriver driver,String screenShotName) throws Throwable {
	TakesScreenshot t=(TakesScreenshot) driver;
	File src = t.getScreenshotAs(OutputType.FILE);
	File dst=new File("./screenshot/"+screenShotName+".PNG");
	Files.copy(src, dst);
}
/**
 * it is used to perform scroll by actions
 * @param driver
 */
public void scroolBarAction(WebDriver driver) {
	JavascriptExecutor javaScript=(JavascriptExecutor) driver; 
	javaScript.executeScript("windows.scrollBy(0,500)");
	
}
}
