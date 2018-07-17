package com.weeschool.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.weeschool.Common_lib.BaseTestScript;
import com.weeschool.Common_lib.CommonUtil;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PlayFullBathPage 
{
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	private WebElement YesButtonForDownload;
	
	@AndroidFindBy(id="com.weeschool.weeschool:id/captext")
	private WebElement playFullBathDownloadSuccessMessage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Water Music Suite No. 1, Allegro']")
	private WebElement playFullBathSong1;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Music for the Royal Fireworks, La réjouissance']")
	private WebElement playFullBathSong2;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Brandenburg Concerto No. 4']")
	private WebElement playFullBathSong3;
	
//	@AndroidFindBy(xpath="//android.widget.TextView[@text='The Four Seasons, "Autumn"']")
//	private WebElement playFullBathSong4;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Brandenburg Concerto No. 5']")
	private WebElement playFullBathSong5;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Water Music, Harlequinade']")
	private WebElement playFullBathSong6;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Water Music Suite No. 1, Alla Hornpipe']")
	private WebElement playFullBathSong7;
	
	@AndroidFindBy(id="cv")
	private WebElement minimizeSongsPlayer;
	
	public PlayFullBathPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTestScript.driver), this);
	}
	
	@Test
	public void PlayFullBathSongsDownload() throws InterruptedException
	{
		Thread.sleep(1000);
		YesButtonForDownload.click();
		CommonUtil.waitTillElementFound(playFullBathDownloadSuccessMessage, 600);
		String expRes ="Playful Bath";
		String actRes = playFullBathDownloadSuccessMessage.getText();
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
	public void playAllSongsOfPlayFullBath() throws InterruptedException
	{
		/*playFullBathSong1.click();
		//minimizeSongsPlayer.click();
		playFullBathSong2.click();
		playFullBathSong3.click();*/
		Thread.sleep(1000);
		for(int i=0; i<=10; i++)
		  { 
		   BaseTestScript.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		   if(BaseTestScript.driver.findElements(By.xpath("//*[@class='android.widget.TextView' and @text='Water Music, Harlequinade']")).size()!= 0)
		   {
			   playFullBathSong6.click();
			   break;
		   }
		   else
		   {
			   CommonUtil.verticalScrollDownwards();
		   }
		  }
		
	}
	

}
