package com.weeschool.Users;

import org.testng.annotations.Test;

import com.weeschool.Common_lib.BaseTestScript;
import com.weeschool.Common_lib.ExcelLib;
import com.weeschool.Pages.ActivitesNewBornPage;
import com.weeschool.Pages.HomePage;
import com.weeschool.Pages.MediaCenterPage;
import com.weeschool.Pages.PlayFullBathPage;
import com.weeschool.Pages.SignUpPage;
import com.weeschool.Pages.WeeTunesPage;
import com.weeschool.Pages.WelcomePage;

public class WeeTunesAlbumTC_01 extends BaseTestScript 
{
	@Test
	public void playAllSongsOfPlayFullBath() throws InterruptedException
	{
		int rowno =2;
		String path="./Testdata/SignupUserdata.xlsx";
		ExcelLib excel = new ExcelLib(path);
		String username = excel.getCellData("Signup", "USERNAME", rowno);
		String email = excel.getCellData("Signup", "EMAIL", rowno);
		
		WelcomePage wl = new WelcomePage();
		SignUpPage sign = new SignUpPage();
		HomePage hm = new HomePage();
		WeeTunesPage wetune = new WeeTunesPage();
		MediaCenterPage mediacenter = new MediaCenterPage();
		PlayFullBathPage playfullbath = new PlayFullBathPage();
		
		wl.clickOnNextSlide();
		sign.signUp(username,email);
		//hm.clickOnMediaCenter();
		//Thread.sleep(1000);
		mediacenter.clickOnWeeTunesAlbum();
		//wetune.weeTunesLibrary();
		//wetune.playTime1();
		//wetune.babyLullabies();
		wetune.playFullBath();
		playfullbath.PlayFullBathSongsDownload();
		playfullbath.playAllSongsOfPlayFullBath();
		
	}
	
	@Test 
	public void Activities() throws InterruptedException
	{
		int rowno =2;
		String path="./Testdata/SignupUserdata.xlsx";
		ExcelLib excel = new ExcelLib(path);
		String username = excel.getCellData("Signup", "USERNAME", rowno);
		String email = excel.getCellData("Signup", "EMAIL", rowno);
		
		WelcomePage wl = new WelcomePage();
		SignUpPage sign = new SignUpPage();
		
		wl.clickOnNextSlide();
		sign.signUp(username,email);
		HomePage hm = new HomePage();
		ActivitesNewBornPage ac = new ActivitesNewBornPage();
		
		hm.clickOnActivites();
		ac.NewBorn();
		
	}
	
	
		
}
