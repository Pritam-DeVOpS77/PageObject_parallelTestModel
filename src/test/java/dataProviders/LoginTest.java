package dataProviders;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	String URL ="https://www.saucedemo.com/";
	
	@BeforeTest
	public void tearUp() {
	    driver = new EdgeDriver();
		driver.manage().window().maximize();
				
	}
	
	@Test(priority=1, dataProvider="cred")
	public void loginTest(String username , String pwd) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		Thread.sleep(1500);
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
	}
	
	@Test(priority=2)
	public void logoTest() {
		boolean logoStatus = driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		Assert.assertEquals(logoStatus, true, "logo is not present");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider(name="cred" , indices= {0,1}) // With indices you can use any cred.
	Object[][] loginData(){
		Object data[][]= {	         
				{ "standard_user","secret_sauce" },
				{ "problem_user","secret_sauce" },
				{ "locked_out_user","secret_sauce" },	          
		};
				return data;	
	}
}
