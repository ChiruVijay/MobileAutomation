package com.weeschool.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.weeschool.Common_lib.BaseTestScript;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage 
{
	@AndroidFindBy(xpath="//android.widget.ImageView[@id='com.weeschool.weeschool:id/milestones']")
	private WebElement mileStonesButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@id='com.weeschool.weeschool:id/playplans']")
	private WebElement activitiesButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@id='com.weeschool.weeschool:id/forbaby']")
	private WebElement mediaCenterButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@id='com.weeschool.weeschool:id/journal']")
	private WebElement scrapBookButton;
	
	
	public BasePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTestScript.driver), this);
	}

}
