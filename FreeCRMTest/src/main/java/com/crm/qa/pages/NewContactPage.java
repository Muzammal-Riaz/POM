package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewContactPage extends TestBase {
	
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement first_name;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement last_name;
	
	@FindBy(xpath = "//input[@name='middle_name']")
	WebElement middle_name;

	@FindBy(xpath = "//div[@name='company']//input[@class='search']")
	WebElement company_name;
	
	@FindBy(xpath = "//input[@placeholder='Email address']")
	WebElement email_1;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement save_btn;
	

	public NewContactPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public void CreateNewContact(String ft, String lt, String mt, String comp, String em)
	
	{
		first_name.sendKeys("Virat");
		last_name.sendKeys("Kohli");
		middle_name.sendKeys("King");
		company_name.sendKeys("bestbatsman");
		email_1.sendKeys("vk@gmail.com");
		save_btn.click();

		
		
		
	}

}
