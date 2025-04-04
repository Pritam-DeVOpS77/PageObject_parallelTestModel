package com.seleniumGrid;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestSeleniumGridSetup {
	
	@Test
	public void testSetUp() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		//customize browser session
		ChromeOptions cap = new ChromeOptions();
		
		//URL
		URL url = new URI("http://localhost:4444/").toURL();
		
		//start the session on remote browser
		WebDriver driver = new RemoteWebDriver(url, cap);
		
		System.out.println("Remote browser session started");
		
		Thread.sleep(4000);
		driver.get("https://www.saucedemo.com/");
		
		Thread.sleep(10000);
		System.out.println("The title is : "+driver.getTitle());
		
		driver.quit();
		
		System.out.println("Remote driver session closed.....");
	}

}
