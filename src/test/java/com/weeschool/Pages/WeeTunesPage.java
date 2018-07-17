package com.weeschool.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.weeschool.Common_lib.BaseTestScript;
import com.weeschool.Common_lib.CommonUtil;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WeeTunesPage 
{
	@AndroidFindBy(xpath="//*[@class='android.widget.LinearLayout' and @index='0']")
	private WebElement weeTunesLibrary;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.LinearLayout' and @index='1']")
	private WebElement babyLullubabies;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.LinearLayout' and @index='2']")
	private WebElement playTime1;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.LinearLayout' and @index='3']")
	private WebElement playTime2;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.LinearLayout' and @index='4']")
	private WebElement playfulBath;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.LinearLayout' and @index='5']")
	private WebElement soothingBath;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.LinearLayout' and @index='6']")
	private WebElement songBook;
	
	
	
	public WeeTunesPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTestScript.driver), this);
	}
	
	
	
	@Test
	public void weeTunesLibrary()
	{
		weeTunesLibrary.click();
	}
	
	@Test
	public void babyLullabies()
	{
		babyLullubabies.click();
	}
	
	@Test
	public void playTime1()
	{
		//Used for loop to scroll tabs until Tab 11 displayed.
		  for(int i=0; i<=10; i++)
		  {
		   //Set implicit wait to 2 seconds for fast horizontal scrolling.
		   BaseTestScript.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);   
		   if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.LinearLayout' and @index='2']")).size()!= 0)
		   {
		    //If PlayTime Is displayed then click on It.
			   playTime1.click();
			   break;
		   }
		   else
		   {
		    //If PlayfulBath Is not displayed then scroll tabs from right to left direction by calling ScrollTabs() method.
			   CommonUtil.horizontalScroll();
		   }
		  }
	}
	
	@Test
	public void playTime2()
	{
		  for(int i=0; i<=10; i++)
		  { 
		   if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.LinearLayout' and @index='3']")).size()!= 0)
		   {
			   playTime2.click();
			   break;
		   }
		   else
		   {
			   CommonUtil.horizontalScroll();
		   }
		  }
	}
	
	@Test
	public void playFullBath()
	{
		for(int i=0; i<=10; i++)
		  { 
		   BaseTestScript.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		   if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.LinearLayout' and @index='4']")).size()!= 0)
		   {
			   playfulBath.click();
			   break;
		   }
		   else
		   {
			   CommonUtil.horizontalScroll();
		   }
		  }
		
	}
	
	

}
