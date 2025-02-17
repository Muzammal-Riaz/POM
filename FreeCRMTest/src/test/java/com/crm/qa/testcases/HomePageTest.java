package com.crm.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;;

public class HomePageTest extends TestBase {
	
	ContactsPage ContactsPage;
	DealsPage DealsPage;
	TasksPage TasksPage;
	HomePage HomePage;
	LoginPage LoginPage;

	public HomePageTest() throws IOException
	{
		super();
		
	}
	@BeforeMethod
	
	public void SetUpHomePage() throws IOException
	{
		initialization();
		LoginPage = new LoginPage();
//		HomePage = LoginPage.login(Prop.getProperty("email"), Prop.getProperty("password"));
//		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		HomePage = new HomePage();
		
	}
	
	@Test (priority=3)
	public void verifyhomepagetitleTest() throws IOException
	{
		HomePage = LoginPage.login(Prop.getProperty("email"), Prop.getProperty("password"));
		String homepage_Title=HomePage.verifyhomepagetitle();
		Assert.assertEquals(homepage_Title, "Cogmento CRM");
		
	}
	
	@Test (priority=4)
	public void verifyusernameTest() throws IOException
	{
		HomePage = LoginPage.login(Prop.getProperty("email"), Prop.getProperty("password"));
		String username_label=HomePage.verifyusername();
		Assert.assertEquals(username_label, "Muzammil Riaz");
		
	}
	
	@Test (priority=5)
	public void clickonContactsTest() throws IOException, InterruptedException
	{
		HomePage = LoginPage.login(Prop.getProperty("email"), Prop.getProperty("password"));
		ContactsPage = HomePage.clickonContacts();
	}
	
	@Test (priority=6)
	public void clickonDealsTest() throws IOException
	{
		HomePage = LoginPage.login(Prop.getProperty("email"), Prop.getProperty("password"));
		DealsPage = HomePage.clickonDeals();
	}
	
	@Test (priority=7)
	public void clickonTasksTest() throws IOException
	{
		HomePage = LoginPage.login(Prop.getProperty("email"), Prop.getProperty("password"));
		TasksPage = HomePage.clickonTasks();
	}
	
	@AfterMethod
	
	public void teardownHomepage()
	{
		
		driver.quit();	
	}

}
