package com.selenium.common;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver = null;

	@SuppressWarnings("deprecation")
	@Parameters("browserName")
	@BeforeTest
	public void intializeBrowser(String browserName )
	{
		switch (browserName.toLowerCase()) {
		case "chrome":
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Annangi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
			break;
		case "firefox":
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Annangi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new FirefoxDriver();
			break;

		default:
			System.out.println("browser name is invalid");
			break;

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() throws InterruptedException
	{

	driver.quit();
	Thread.sleep(5000);
}
}
