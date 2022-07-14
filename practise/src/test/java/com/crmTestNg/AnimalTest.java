package com.crmTestNg;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AnimalTest {

	 @Test(dependsOnMethods = "ratTest",timeOut = 3000)
	 public void elephantTest() {
		// System.out.println("big");
		 Reporter.log("big",true);
		 
	 }
	 
	 @Test()
	 public void dogTest() {
		// System.out.println("medium");
		 Reporter.log("medium",true);
	 }

	 
	 @Test()
	 public void ratTest() {
		// System.out.println("small");
		// Assert.fail();
		 Reporter.log("small",true);
	 }

}
