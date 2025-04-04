package com.seleniumGrid;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parallelTest {
	
  WebDriver driver;
	
  @Test
  @Parameters({"browser"})
  public void testParallelEcecution( String browser) throws MalformedURLException, URISyntaxException, InterruptedException {
	  
	  if(browser.equalsIgnoreCase("chrome")) {
		  ChromeOptions cap = new ChromeOptions();
		  driver = new RemoteWebDriver(new URI("http://localhost:4444/").toURL(),cap);
	  }
	  else if(browser.equalsIgnoreCase("edge")) 
	  {
		  EdgeOptions cap = new EdgeOptions();
		  driver = new RemoteWebDriver(new URI("http://localhost:4444/").toURL(),cap);
	  }
	  else if(browser.equalsIgnoreCase("firefox")) 
	  {
		  FirefoxOptions cap = new FirefoxOptions();
		  driver = new RemoteWebDriver(new URI("http://localhost:4444/").toURL(),cap);
	  }
	  
	  System.out.println("Remote driver session started ....");
	  
	  Thread.sleep(10000);
	  
	  driver.get("https://www.hotstar.com/in/home");
	  
	  Thread.sleep(10000);
	  
	  System.out.println("The title of the URL is : "+driver.getTitle());
	  
	  driver.quit();
	  
	  System.out.println("Driver session closed .....");
	  
  }
}
