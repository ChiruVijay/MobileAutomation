package com.weeschool.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.weeschool.Common_lib.BaseTestScript;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage 
{
	@AndroidFindBy(xpath="//*[@class='android.widget.Button'][2]")
	private WebElement allowPermissionButton;
		
	@AndroidFindBy(xpath="//*[@class='android.support.v7.app.ActionBar$Tab' and @index='1']")
	private WebElement welcomeslide1;
	
	@AndroidFindBy(xpath="//*[@class='android.support.v7.app.ActionBar$Tab' and @index='2']")
	private WebElement welcomeslide2;
	
	@AndroidFindBy(xpath="//*[@class='android.support.v7.app.ActionBar$Tab' and @index='3']")
	private WebElement welcomeslide3;
	
	@AndroidFindBy(xpath="//*[@class='android.support.v7.app.ActionBar$Tab' and @index='4']")
	private WebElement welcomeslide4;
	
	@AndroidFindBy(id="com.weeschool.weeschool:id/signup")
	private WebElement signUpButton;
	

	public WelcomePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTestScript.driver), this);
		
	}
	
	@Test
	public void clickOnNextSlide()
	{
//		while(BaseTestScript.driver.findElements(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).size()>0)
//		{
//			BaseTestScript.driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();
//		}
		//allowPermissionButton.click();
		welcomeslide1.click();
		welcomeslide2.click();
		welcomeslide3.click();
		welcomeslide4.click();
		signUpButton.click();
		
	}	


}
