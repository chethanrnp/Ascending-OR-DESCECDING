package genericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class myListner implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		String scriptName = result.getMethod().getMethodName();
		System.out.println(scriptName+"=======Executing======");
		EventFiringWebDriver sdriver=new EventFiringWebDriver(BaseClass.edriver);
		File src = sdriver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/"+scriptName+".PNG");
		try {
			FileUtils.copyFile(src,dst );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	/*	try {
			genericUtilities.WebDriverUtility.takeScreenShot(BaseClass.edriver, scriptName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

	 
}
