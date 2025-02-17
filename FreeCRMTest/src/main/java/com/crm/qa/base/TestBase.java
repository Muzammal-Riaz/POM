package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties Prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public TestBase() throws IOException      //constructor
	{
		try 
		{
			
		Prop = new Properties();
		FileInputStream io = new FileInputStream ("C:\\Users\\muzammil.riaz\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties" );
		Prop.load(io);	
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
		catch (IOException e2)
		{
			
			e2.printStackTrace();
		}
	}
	
	public static void initialization () throws IOException  // initialization of browser
	{
		String browsername = Prop.getProperty("browser");
		if (browsername.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\muzammil.riaz\\Desktop\\exe files\\chrome new version\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if (browsername.contentEquals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\muzammil.riaz\\Desktop\\exe files\\chrome new version\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(Prop.getProperty("url"));
	}

}
