package com.weeschool.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.weeschool.Common_lib.BaseTestScript;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage
{
	@AndroidFindBy(id="com.weeschool.weeschool:id/playplans")
	private WebElement activitesButton;
	
	@AndroidFindBy(id="com.weeschool.weeschool:id/forbaby")
	private WebElement mediaCenterButton;
	
	public HomePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTestScript.driver), this);
	}
	
	@Test
	public void clickOnActivites()
	{
		activitesButton.click();
	}
	@Test
	public void clickOnMediaCenter()
	{
		mediaCenterButton.click();
	}

}
