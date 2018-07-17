package com.weeschool.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.weeschool.Common_lib.BaseTestScript;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MediaCenterPage 
{
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.weeschool.weeschool:id/weetune']")
	private WebElement weetunesButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.weeschool.weeschool:id/sleep']")
	private WebElement musicNightLightButton;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id='com.weeschool.weeschool:id/weetube']")
	private WebElement weetubeVideosButton;
	
	public MediaCenterPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTestScript.driver), this);
	}

	@Test
	public void clickOnWeeTunesAlbum()
	{
		weetunesButton.click();
	}
	
	@Test
	public void clickOnWeeTubeVideos()
	{
		weetubeVideosButton.click();
	}
	
	@Test
	public void clickOnMusicalNightLight()
	{
		musicNightLightButton.click();
	}
	

}
