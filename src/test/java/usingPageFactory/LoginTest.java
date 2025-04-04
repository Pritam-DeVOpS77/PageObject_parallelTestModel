package usingPageFactory;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	String URL ="https://www.saucedemo.com/";
	
	@BeforeTest
	public void tearUp() {
	    driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);			
	}
	
	@Test(priority=1)
	public void loginTest()  {
        LoginPage2 lp =new LoginPage2(driver);
        lp.UserName("standard_user");
        lp.pwd("secret_sauce");
        lp.SubmitButton();
        
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
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

}
