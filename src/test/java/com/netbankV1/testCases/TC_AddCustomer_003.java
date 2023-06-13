package com.netbankV1.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbankV1.pageObjects.AddCustomerPage;
import com.netbankV1.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username is provided");
		
		lp.setPassword(password);
		logger.info("Passsword is provided");
		
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Providing the customer details");
		
		addcust.custName("Balaji");
		addcust.custgender("male");
		addcust.custdob("17","04","1992");
		
		Thread.sleep(5000);
		
		addcust.custaddress("INDIA");
		addcust.custcity("Chennai");
		addcust.custstate("TamilNadu");
		addcust.custpinno("600041");
		addcust.custtelephoneno("9790123456");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		
		/*
		addcust.custpassword("abcd1234");  //bug in the site: "Connection failed: Access denied for user 'root'@'localhost' (using password: NO)"
		addcust.custsubmit();			   //bug in the site: "Connection failed: Access denied for user 'root'@'localhost' (using password: NO)"
		*/
		
		Thread.sleep(3000);
		
		logger.info("Validation is started");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
			
		}
		else
		{
			logger.info("Test case failed");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}

}
