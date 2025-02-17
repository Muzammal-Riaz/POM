/* Muzammil Riaz
 * SQA Engineer
 *  */


package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.HomePage;

public class LoginPageTest extends TestBase {
	
	LoginPage LoginPage;
	HomePage HomePage;

	public LoginPageTest() throws IOException
	{
		super();
		
	}
	
	@BeforeMethod
	
	public void SetUp() throws IOException
	{
		initialization();
		LoginPage = new LoginPage();
		
	}
	
	@Test (priority=1)
	
	public void LoginPageTitle()
	{
		String LoginPage_Title = LoginPage.validateloginpagetitle();
		Assert.assertEquals(LoginPage_Title,"Cogmento CRM");
		
	}
	
	@Test (priority=2)
	
	public void LoginTest() throws IOException, InterruptedException
	{
		HomePage = LoginPage.login(Prop.getProperty("email"), Prop.getProperty("password"));
		System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
		Thread.sleep(1000);
	}
	
	@AfterMethod
	
	public void teardown()
	{
		driver.quit();	
	}
}