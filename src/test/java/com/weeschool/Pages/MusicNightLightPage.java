package com.weeschool.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.weeschool.Common_lib.BaseTestScript;
import com.weeschool.Common_lib.CommonUtil;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MusicNightLightPage
{
	@AndroidFindBy(xpath="//android.widget.Button[@id='android:id/button1']")
	private WebElement musicNightLightDownloadButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@id='com.weeschool.weeschool:id/register']")
	private WebElement musicNightLightDownloadSuccessMessage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@id='com.weeschool.weeschool:id/register']")
	private WebElement startNightLightButton;
	
	public MusicNightLightPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTestScript.driver), this);
	}

	@Test
	public void musicNightLightSongsDownload()
	{
		musicNightLightDownloadButton.click();
		CommonUtil.waitTillElementFound(musicNightLightDownloadSuccessMessage, 1000);
		String expRes ="START NIGHTLIGHT";
		String actRes = musicNightLightDownloadSuccessMessage.getText();
		if(actRes.equals(expRes))
		{
			System.out.println("Succesfully downloaded");
		}
		else
		{
			System.out.println("Downloade failured");
		}	
	}
	
	@Test
	public void startNightLightTest()
	{
		startNightLightButton.click();
		
		
		
		
	}
}
