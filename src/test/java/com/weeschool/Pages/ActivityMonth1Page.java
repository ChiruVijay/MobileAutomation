package com.weeschool.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.weeschool.Common_lib.BaseTestScript;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ActivityMonth1Page 
{
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.weeschool.weeschool:id/nextbtn']")
	private WebElement nextButton;
	
	
	
	
	
	
	
	
	public ActivityMonth1Page()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTestScript.driver), this);
	}

}
