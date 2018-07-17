package com.weeschool.Common_lib;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DateSelector 
{
	public static void selectDate(String year,String mon,String date) throws MalformedURLException
	{
		
		/*File fs = new File("src","ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S7");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Dialog']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='change the date']")).click();*/
		
		//************************ TO SELECT A YEAR ********************************
		
		WebElement yearButton= BaseTestScript.driver.findElement(By.id("android:id/date_picker_year"));
		String currentYear = yearButton.getText();
		
			if(currentYear.equalsIgnoreCase(year))
			{
				
				
			}
			else
			{
				do
				{
					yearButton.click();
					List<WebElement> l = BaseTestScript.driver.findElements(By.xpath("//android.widget.TextView"));
					for(WebElement yr : l)
					{
						if(yr.getText().equals(year))
						{
							BaseTestScript.driver.findElement(By.xpath("//android.widget.TextView[@text='"+year+"']")).click();
							break;
						}
					}
					//****************____ SWIPE UPWARDS____******************************
					
					Dimension size = BaseTestScript.driver.manage().window().getSize(); 
					int x = size.getWidth() / 2;     
					int starty = (int) (size.getHeight() * 0.60);   
					int endy = (int) (size.getHeight() * 0.10); 
					TouchAction t = new TouchAction(BaseTestScript.driver);
					t.press(x, starty).waitAction().moveTo(x, endy).release().perform();				
				}
				while(!BaseTestScript.driver.findElement(By.xpath("//android.widget.TextView")).getText().equalsIgnoreCase(year));  
			}
	
		//********************** TO SELECT A MONTH ******************************
		
		//String m = "Jul";
		String month= BaseTestScript.driver.findElement(By.xpath("//android.view.View[@text='1']")).getAttribute("name").substring(2,6);	
		
		if(month.contains(mon))
		{  
    		
		}
		else
		{	
			do
			{
				BaseTestScript.driver.findElementById("android:id/next").click();
				String month1= BaseTestScript.driver.findElement(By.xpath("//android.view.View[@text='1']")).getAttribute("name").substring(2, 6);
				if(month1.contains(mon))
				{
					break;
				}	
			}
				while(!BaseTestScript.driver.findElement(By.xpath("//android.view.View[@text='1']")).getAttribute("name").substring(2, 6).contains(mon));
		}
	
	//************************** TO SELECT A DATE ************************************
			
		
		//String date = "19";
		
		List<WebElement> dates = BaseTestScript.driver.findElements(By.xpath("//android.view.View"));
		for(WebElement cdate : dates)
		{
			if(cdate.getText().equalsIgnoreCase(date))
			{
				BaseTestScript.driver.findElement(By.xpath("//android.view.View[@text='"+date+"']")).click();
				break;
			}
		}
		BaseTestScript.driver.findElementById("android:id/button1").click();
}



}
