package com.netbankV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbankV1.pageObjects.LoginPage;

public class TC_LoginPage_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException 
	{
			
		logger.info("URL opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Page Passed");
		}
		else
		{
			captureScreen(driver,"LoginPage");
			Assert.assertTrue(false);
			logger.info("Login Page Failed");
		}
		
	}

}
