package com.weeschool.Common_lib;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

//@Listeners(CustomListener.class)
public class BaseTestScript 
{
	public static AndroidDriver driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	public static ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void beforeSuit()
	{
		report = new ExtentReports("E:\\ECLIPSE WORKSPACE\\WEESCHOOL\\Extent Reports\\report.html");
		logger = report.startTest("Test1Preference");
		
	}

	@Parameters({"device","version","appiumServer"})
	@BeforeMethod
	public void preSteps(String device,String version, String appiumServer) throws MalformedURLException
	{
		File fs = new File("APK file","app-debug.apk");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability("appPackage", "com.weeschool.weeschool");
		cap.setCapability("appActivity", "com.weeschool.weeschool.SplashActivity");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,device);	
		cap.setCapability(MobileCapabilityType.UDID,device);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,Platform.ANDROID);
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.ANDROID);
		cap.setCapability(MobileCapabilityType.VERSION,version);

		URL url= new URL(appiumServer);
		driver = new AndroidDriver<MobileElement>(url,cap);	
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		/*cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		//driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		if(device.equalsIgnoreCase("192.168.146.101:5555"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.146.101:5555");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		}
		else if(device.equalsIgnoreCase("dca52218"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "dca52218");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"), cap);
		}
		else if(device.equalsIgnoreCase("192.168.146.102:5555"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.146.102:5555");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4725/wd/hub"), cap);
		}
		else if(device.equalsIgnoreCase("4d00c2664d6851e9"))
		{
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "4d00c2664d6851e9");
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4726/wd/hub"), cap);
		}
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);*/
		
		
	}
		
	
	@AfterMethod
	public void postSteps()
	{
//		cap.setCapability(MobileCapabilityType.FULL_RESET, true);
//		cap.setCapability(MobileCapabilityType.NO_RESET, false);
//		when driver started with "fullReset=true" or "noReset=false" driver.closeApp() 
//		cause to uninstall application in simulator and simulator close.
//		when driver started with "fullReset=false" + "noReset=true" driver.closeApp() 
//		does not uninstall app but just close it without closing Simulator.
		
	driver.quit();

	}
	
	@AfterSuite
	public void afterSuite()
	{
		report.endTest(logger);
		report.flush();
		
	}

}
