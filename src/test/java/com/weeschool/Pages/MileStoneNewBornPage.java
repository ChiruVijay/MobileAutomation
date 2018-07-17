package com.weeschool.Pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class MileStoneNewBornPage
{
	@AndroidFindBy(xpath="//android.widget.ImageView[@id='com.weeschool.weeschool:id/image1']")
	private WebElement addImageButton;

}
