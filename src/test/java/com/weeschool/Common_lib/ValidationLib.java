package com.weeschool.Common_lib;

import org.testng.Assert;

public class ValidationLib 
{
	public static void verifySuccessMsg(String expRes, String actRes,String xlpath, String sheetName,String cellno, String rowno)
	{
		try
		{
			Assert.assertEquals(actRes, expRes);
		}
		catch(AssertionError e)
		{
			
		}
	}

}
