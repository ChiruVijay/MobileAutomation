package com.weeschool.Common_lib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

public class CustomListener implements ITestListener
{

	public void onTestFailure(ITestResult res) 
	{
		String mn = res.getName();
		takeScreenShot(mn);
		BaseTestScript.logger.addScreenCapture(mn);
	}
	
	public void takeScreenShot(String methodName)
	{
		try
		{
		AndroidDriver ad = (AndroidDriver)BaseTestScript.driver;
		TakesScreenshot ts = (TakesScreenshot)BaseTestScript.driver;
		File src = ad.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+methodName+".png");
		FileUtils.moveFile(src, dest);
		
		}
		catch(IOException e)
		{
			System.out.println("Exception while taking screenshots"+e.getMessage());
		}
	}
	
	public void onFinish(ITestContext arg0) {	
	}

	public void onStart(ITestContext arg0) {	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}
	
	public void onTestSkipped(ITestResult arg0) {
	}

	public void onTestStart(ITestResult arg0) {
	}

	public void onTestSuccess(ITestResult arg0) {
	}
	

}
