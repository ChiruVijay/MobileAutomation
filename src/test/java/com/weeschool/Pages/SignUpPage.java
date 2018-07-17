package com.weeschool.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.weeschool.Common_lib.BaseTestScript;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage 
{
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.weeschool.weeschool:id/firstname']")
	private WebElement enterFirstName;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.weeschool.weeschool:id/email']")
	private WebElement enterEmail;
	
	@AndroidFindBy(id="com.weeschool.weeschool:id/signup")
	private WebElement signUpButton;
	
	@AndroidFindBy(id="com.weeschool.weeschool:id/login_button")
	private WebElement signUpWithFacebook;
	
	@AndroidFindBy(id="android:id/button1")
    private WebElement allowPopupButtonForNotification;
	
	@AndroidFindBy(id="com.weeschool.weeschool:id/edit1")
	private WebElement enterEmailForVerificationPopUp;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement OkButtonOfEmailVerificationPopUp;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.weeschool.weeschool:id/firstname']")
	private WebElement firstName;
	
	@AndroidFindBy(id="com.weeschool.weeschool:id/datecover")
	private WebElement DOB;
	
	@AndroidFindBy(id="com.weeschool.weeschool:id/signup")
	private WebElement continueButton;
	
	@AndroidFindBy(id="com.weeschool.weeschool:id/maybelater")
	private WebElement maybeLaterButton;
	
	@AndroidFindBy(id="android:id/button2")
	private WebElement MissingInfoPopUPSkipButton;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement MissingInfoPopUPAddButton;
	
	@AndroidFindBy(id="com.weeschool.weeschool:id/signup") 
	private WebElement LetsGoButton;
	
	
	
	public SignUpPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(BaseTestScript.driver), this);
	}

	@Test
	public void signUp(String un,String uemail)   
	{
		allowPopupButtonForNotification.click();
		enterFirstName.sendKeys(un);
		enterEmail.sendKeys(uemail);	
		signUpButton.click();
		enterEmailForVerificationPopUp.sendKeys(uemail);
		OkButtonOfEmailVerificationPopUp.click();
		firstName.sendKeys("abc");
		//DOB.click();
		maybeLaterButton.click();
		MissingInfoPopUPSkipButton.click();
		LetsGoButton.click();
		
		
	}
}
