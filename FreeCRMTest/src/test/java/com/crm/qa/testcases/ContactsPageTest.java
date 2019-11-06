package com.crm.qa.testcases;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	ContactsPage ContactsPage;
	DealsPage DealsPage;
	TasksPage TasksPage;
	HomePage HomePage;
	LoginPage LoginPage;
	NewContactPage NewContactPage;
	String sheetName ="Contacts" ;
	

	public ContactsPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	
	public void SetUpHomePage() throws IOException
	{
		initialization();
		LoginPage = new LoginPage();
		HomePage = new HomePage();
		ContactsPage= new ContactsPage();
//		HomePage = LoginPage.login(Prop.getProperty("email"), Prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
	}
	
	@DataProvider
	
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (dataProvider = "getCRMTestData")
	
	public void validateCreateNewContact(String First_Name, String Last_Name, String Middle_Name, String Company_Name, String Email) throws IOException, InterruptedException
	
	{
		HomePage = LoginPage.login(Prop.getProperty("email"), Prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		ContactsPage = HomePage.clickonContacts();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		NewContactPage= ContactsPage.clickonnewContacts();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		NewContactPage.CreateNewContact(First_Name, Last_Name, Middle_Name, Company_Name, Email);
		Thread.sleep(10000);

		
	}
	
	
	@AfterMethod
	
	public void teardownHomepage()
	{
		
		driver.quit();	
	}

}
