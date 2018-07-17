package com.weeschool.Common_lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;

public class CommonUtil 
{
	//Reusable method for scroll tabs right to left In horizontal direction.
	 public static void horizontalScroll()
	 {
		  //Get the size of screen.
		  Dimension size = BaseTestScript.driver.manage().window().getSize();  
		  //Find swipe start and end point from screen's with and height.
		  //Find startx point which is at right side of screen.
		  int startx = (int) (size.width * 0.70);
		  //Find endx point which is at left side of screen.
		  int endx = (int) (size.width * 0.30);
		  //Set Y Coordinates of screen where tabs display.
		  int YCoordinates = 1650;
		  //Swipe tabs from Right to Left.
		  //BaseTestScript.driver.swipe(startx, YCoordinates, endx, YCoordinates, 3000); 
		  TouchAction t = new TouchAction(BaseTestScript.driver);
		  t.press(startx, YCoordinates).waitAction().moveTo(endx, YCoordinates).release().perform();
	 }
	 
	//Reusable method for scroll tabs up to down In Vertical direction.
	 public static void verticalScrollDownwards()
	 {
		  //Get the size of screen.
		  Dimension size = BaseTestScript.driver.manage().window().getSize();   
		  //Find swipe start and end point from screen's with and height.
		  //Find startx point which is at right side of screen.
		  int starty = (int) (size.height * 0.80);
		  //Find endx point which is at left side of screen.
		  int endy = (int) (size.height * 0.20);
		  //Set Y Coordinates of screen where tabs display.
		  int XCoordinates = (int) (size.width/2);
		  //Swipe tabs from Right to Left.
		  //BaseTestScript.driver.swipe(startx, YCoordinates, endx, YCoordinates, 3000); 
		  
		  TouchAction t = new TouchAction(BaseTestScript.driver);
		  t.press(XCoordinates,starty).waitAction().moveTo(XCoordinates, endy).release().perform();
	 }
	 
	//Reusable method for scroll tabs down to up In Vertical direction.
		 public static void verticalScrollUpwards()
		 {
			  //Get the size of screen.
			  Dimension size = BaseTestScript.driver.manage().window().getSize();   
			  //Find swipe start and end point from screen's with and height.
			  //Find startx point which is at right side of screen.
			  int starty = (int) (size.height * 0.20);
			  //Find endx point which is at left side of screen.
			  int endy = (int) (size.height * 0.80);
			  //Set Y Coordinates of screen where tabs display.
			  int XCoordinates = (int) (size.width/2);
			  //Swipe tabs from Right to Left.
			  //BaseTestScript.driver.swipe(startx, YCoordinates, endx, YCoordinates, 3000); 
			  
			  TouchAction t = new TouchAction(BaseTestScript.driver);
			  t.press(XCoordinates,starty).waitAction().moveTo(XCoordinates, endy).release().perform();
		 }
	 
	 
	 //Reusable method for Vertical Scrolling until element to be visible
	 public static void scrollVertiicalUntilElementVisible(WebElement element,String element1)
	 {
		 for(int i=0; i<=10; i++)
		  { 
		   BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		   if(BaseTestScript.driver.findElements(By.xpath(element1)).size()!= 0)
		   {
			   element.click();
			   break;
		   }
		   else
		   {
			   CommonUtil.verticalScrollDownwards();
		   }
		  }
	 }
	 
	 //Reusable method for Horizontal Scrolling until element to be visible
	 public static void scrollHorizonatlUntilElementVisible(WebElement element,String element1)
	 {
		 for(int i=0; i<=10; i++)
		  { 
		   BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		   if(BaseTestScript.driver.findElements(By.xpath(element1)).size()!= 0)
		   {
			   element.click();
			   break;
		   }
		   else
		   {
			   CommonUtil.horizontalScroll();
		   }
		  }
	 }
	 
	 //Reusable method for Vertical Scrolling until element to be visible in "ACTIVITY MODULE"
	 public static void scrollHorizonatlUntilElementVisibleInActivity(WebElement element,String element1)
	 {
		 for(int i=0; i<=10; i++)
		 { 
			 BaseTestScript.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			 if(BaseTestScript.driver.findElements(By.xpath(element1)).size()!= 0)
			 {
				 element.click();
				 CommonUtil.verticalScrollUpwards();
				 break;
			 }
			 else
			 {
				 CommonUtil.verticalScrollDownwards();
			 }
		 }
	 }
	public static void waitTillPresenceElement(By locator)
	{
		WebDriverWait wait = new WebDriverWait(BaseTestScript.driver,300);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
	}
	
	public static void waitTillElementFound(WebElement ElementTobeFound,int seconds)
	{
		WebDriverWait wait = new WebDriverWait(BaseTestScript.driver,seconds);
		wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));
			
	}

}
