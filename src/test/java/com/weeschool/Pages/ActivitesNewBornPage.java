package com.weeschool.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.weeschool.Common_lib.BaseTestScript;
import com.weeschool.Common_lib.CommonUtil;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ActivitesNewBornPage extends BasePage
{
	@AndroidFindBy(id="com.weeschool.weeschool:id/signup")
	private WebElement letsGoButton;
	
	@AndroidFindBy(id="com.weeschool.weeschool:id/letsdo")
	private WebElement letsDoItButton;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id='com.weeschool.weeschool:id/dotcontainer']")
	private WebElement expandDotButtons;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.weeschool.weeschool:id/wedidthis']")
	private WebElement weDidThisButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@index='2']")
	private WebElement activityCompletedButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.weeschool.weeschool:id/bkbtn']")
	private WebElement backButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@id='com.weeschool.weeschool:id/complete1']")
	private WebElement ActivityCompletRightButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.weeschool.weeschool:id/nextbtn']")
	private WebElement nextButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Social and Emotional']")
	private WebElement socialAndEmotionalPlayPlan;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Going Slow']")
	private WebElement goingSlowPlayPlan;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Keeping It Soft']")
	private WebElement keepingItSoftPlayPlan;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Keeping 3-4 Time']")
	private WebElement keeping34TimePlayPlan;
	
	public ActivitesNewBornPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTestScript.driver), this);
	}
	/*
	@Test
	public void NewBorn1() throws InterruptedException
	{
		letsGoButton.click();
		socialAndEmotionalPlayPlan.click();
		letsDoItButton.click();
		for(int i=0;i<=8;i++)
		{
		     do
		     {	
		       	if(BaseTestScript.driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout' and @resource-id='com.weeschool.weeschool:id/dotcontainer']")).isDisplayed())
		       	{
		       		expandDotButtons.click();	
		       	}
		       	else
		       	{
		       		CommonUtil.verticalScrollDownwards();
		       	} 	
		     }
		     while(BaseTestScript.driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout' and @resource-id='com.weeschool.weeschool:id/dotcontainer']")).isDisplayed());
	         expandDotButtons.click();
	         for(int j=0;j<=8;j++)
	         {
	         do
	         {
	        	 CommonUtil.verticalScrollDownwards(); 
	         }
	         while(BaseTestScript.driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.weeschool.weeschool:id/wedidthis']")).isDisplayed());
	         weDidThisButton.click();
	         
	         for(int k=0;k<=8;k++)
	         {
	         do
	         {
	        	 CommonUtil.verticalScrollUpwards(); 
	         }
	         while(BaseTestScript.driver.findElement(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.weeschool.weeschool:id/nextbtn']")).isDisplayed());
	         nextButton.click();	   
			 break;
	         }
	         }
	         break;
		}
	}*/


	
	@Test
	public void NewBorn() throws InterruptedException
	{
		letsGoButton.click();
		SocialAndEmotionalActivity();
		musicGoingSlow();
		for(int i=0;i<3;i++)
		{
			BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @text='Keeping It Soft']")).size()!= 0)
			{
				keepingItSoftPlayPlan();
				break;
			}
			else
			{
				CommonUtil.verticalScrollDownwards();
			}
		}	
		for(int j=0;j<3;j++)
		{
			BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @text='Keeping 3-4 Time']")).size()!= 0)
			{
				keeping34Time();
				break;
			}
			else
			{
				CommonUtil.verticalScrollDownwards();
			}
		}	
	}
	
	public void SocialAndEmotionalActivity() throws InterruptedException
	{
		socialAndEmotionalPlayPlan.click();
		letsDoItButton.click();
		try
		{
			outer:
			for(int k=0;k<=8;k++)
			{
				do
				{
					BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					CommonUtil.verticalScrollDownwards();
					break;
				}
				while(BaseTestScript.driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout' and @resource-id='com.weeschool.weeschool:id/dotcontainer']")).isDisplayed());	
				
				expandDotButtons.click();
				 for(int i=0; i<=8; i++)
						{ 
							BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
							if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.weeschool.weeschool:id/wedidthis']")).size()!= 0)
							{
								weDidThisButton.click();
								for(int j=0; j<=8; j++)
								{ 
									BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
									if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.weeschool.weeschool:id/nextbtn']")).size()!= 0)
									{
										nextButton.click();	
										Thread.sleep(1000);
										break;
									}
									else
									{
										CommonUtil.verticalScrollUpwards();
										if(j==3)
										{	
											backButton.click();
											break outer;
										}
									}
								}
								break;
							}
							else
							{
								CommonUtil.verticalScrollDownwards();
							}
						}
				}
		}
		catch(NoSuchElementException e)
		{
			backButton.click();
		}
		
	}
	
	public void musicGoingSlow() throws InterruptedException
	{
		goingSlowPlayPlan.click();
		letsDoItButton.click();
		BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		try
		{
			outer:
			for(int k=0;k<=8;k++)
			{
				do
				{
					BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					CommonUtil.verticalScrollDownwards();
					break;
				}
				while(BaseTestScript.driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout' and @resource-id='com.weeschool.weeschool:id/dotcontainer']")).isDisplayed());	
				
				expandDotButtons.click();
				 for(int i=0; i<=8; i++)
						{ 
							BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
							if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.weeschool.weeschool:id/wedidthis']")).size()!= 0)
							{
								weDidThisButton.click();
								for(int j=0; j<=8; j++)
								{ 
									BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
									if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.weeschool.weeschool:id/nextbtn']")).size()!= 0)
									{
										nextButton.click();	
										Thread.sleep(1000);
										break;
									}
									else
									{
										CommonUtil.verticalScrollUpwards();
										if(j==3)
										{	
											backButton.click();
											break outer;
										}
									}
								}
								break;
							}
							else
							{
								CommonUtil.verticalScrollDownwards();
							}
						}
				}
		}
		catch(NoSuchElementException e)
		{
			backButton.click();
		}
	}
	public void keepingItSoftPlayPlan() throws InterruptedException
	{
		keepingItSoftPlayPlan.click();
		letsDoItButton.click();
		BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		try
		{
			outer:
			for(int k=0;k<=8;k++)
			{
				do
				{
					BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					CommonUtil.verticalScrollDownwards();
					break;
				}
				while(BaseTestScript.driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout' and @resource-id='com.weeschool.weeschool:id/dotcontainer']")).isDisplayed());	
				
				expandDotButtons.click();
				 for(int i=0; i<=8; i++)
						{ 
							BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
							if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.weeschool.weeschool:id/wedidthis']")).size()!= 0)
							{
								weDidThisButton.click();
								for(int j=0; j<=8; j++)
								{ 
									BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
									if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.weeschool.weeschool:id/nextbtn']")).size()!= 0)
									{
										nextButton.click();	
										Thread.sleep(1000);
										break;
									}
									else
									{
										CommonUtil.verticalScrollUpwards();
										if(j==3)
										{	
											backButton.click();
											break outer;
										}
									}
								}
								break;
							}
							else
							{
								CommonUtil.verticalScrollDownwards();
							}
						}
				}
		}
		catch(NoSuchElementException e)
		{
			backButton.click();
		}
	}
	
	public void keeping34Time() throws InterruptedException
	{
		keeping34TimePlayPlan.click();
		letsDoItButton.click();
		BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		try
		{
			outer:
			for(int k=0;k<=8;k++)
			{
				do
				{
					BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					CommonUtil.verticalScrollDownwards();
					break;
				}
				while(BaseTestScript.driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout' and @resource-id='com.weeschool.weeschool:id/dotcontainer']")).isDisplayed());	
				
				expandDotButtons.click();
				 for(int i=0; i<=8; i++)
						{ 
							BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
							if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.weeschool.weeschool:id/wedidthis']")).size()!= 0)
							{
								weDidThisButton.click();
								for(int j=0; j<=8; j++)
								{ 
									BaseTestScript.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
									if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @resource-id='com.weeschool.weeschool:id/nextbtn']")).size()!= 0)
									{
										nextButton.click();	
										Thread.sleep(1000);
										break;
									}
									else
									{
										CommonUtil.verticalScrollUpwards();
										if(j==3)
										{	
											backButton.click();
											break outer;
										}
									}
								}
								break;
							}
							else
							{
								CommonUtil.verticalScrollDownwards();
							}
						}
				}
		}
		catch(NoSuchElementException e)
		{
			backButton.click();
		}
	}
	}


