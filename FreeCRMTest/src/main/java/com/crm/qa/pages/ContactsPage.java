package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	


	@FindBy(xpath = "//i[@class='edit icon']")
	WebElement NewContact;
	

	
	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public NewContactPage clickonnewContacts() throws IOException
	{
		NewContact.click();
		return new NewContactPage();
		
		
		
	}
	


}
