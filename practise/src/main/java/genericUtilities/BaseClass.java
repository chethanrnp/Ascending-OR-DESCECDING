package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.objectRepositry.Homepage;
import com.crm.objectRepositry.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	 public  WebDriver driver;
	 public static WebDriver edriver;
	 public DatabaseUtility dLib=new DatabaseUtility();
	 public ExcelUtility eLib=new ExcelUtility();
	 public FileUtility fLib=new FileUtility();
	 public WebDriverUtility wLib=new WebDriverUtility();
	/**
	 * connecting to database 
	 */
	 @BeforeSuite(groups = {"SmokeTest","regressionTest"})
	 public void dbCongig() {
		 dLib.connectToDb();
	 }
	//@Parameters("Browser")
	 @BeforeClass(groups = {"SmokeTest","regressionTest"})
	 public void launchTheBrowser() {
		 //fetches the data from property file 
		 String Browser = fLib.getPropertyKeyValue(IPathConstants.filePath,"browser" );
		 String url = fLib.getPropertyKeyValue(IPathConstants.filePath, "url");
		 //launches the browser
		 if(Browser.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		 }
		 else if(Browser.equalsIgnoreCase("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		 }
		 else  
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver(); 
		 }
		 edriver =driver;
		 //enters the url of the application
		 driver.get(url);
		 //maximize the window
		 driver.manage().window().maximize();
		 //waits for page to be loaded
		 wLib.waitForPageToLoad(driver);
		 //waits for elemnts 
		 wLib.waitForPageToLoadForJSEElement(driver);
		 driver.manage().deleteAllCookies();
		 }
	 /**
	  * login to aplication
	  */
	 @BeforeMethod(groups = {"SmokeTest","regressionTest"})
	 public void loginToAppLn() {
		String usn = fLib.getPropertyKeyValue(IPathConstants.filePath, "usn");
		String pwd = fLib.getPropertyKeyValue(IPathConstants.filePath, "pwd");
		 LoginPage lpage =new LoginPage(driver);
		 lpage.loginPage(usn, pwd);
		 
	 }
	 /**
	  * logout from application
	 * @throws Throwable 
	  */
	 @AfterMethod(groups = {"SmokeTest","regressionTest"})
	 public void logOutFromApp() throws Throwable {
		 Homepage hpage=new Homepage(driver);
		 hpage.clickOnLogOut(driver);
	 } 
	 /**
	  * closes the browser
	  */
	 @AfterClass(groups = {"SmokeTest","regressionTest"})
	 public void closeBrowser() {
		driver.quit();
	}
	 /**
	  * closes thr DB
	  */
	 @AfterSuite(groups = {"SmokeTest","regressionTest"})
	 public void coseDbConfig() {
		dLib.closeDb(); 
	 }
}
