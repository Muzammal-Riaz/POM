package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase 
{

	@FindBy(name = "email" )
	WebElement Email;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy (xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement Login;
	
	@FindBy (xpath ="1")
	WebElement SignUp;
	
	
	public LoginPage() throws IOException // TODO Auto-generated constructor stub
	{
		PageFactory.initElements(driver, this);
		
	}

	
	public  String validateloginpagetitle() 
	{

		return driver.getTitle();
		
	}
	
	public HomePage login (String em, String pwd) throws IOException
	{
		Email.sendKeys(em);
		Password.sendKeys(pwd);
		Login.click();
		
		return new HomePage();
	}
	
	
}
