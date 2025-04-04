package serialAndParallelTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTestCase {
	
	WebDriver driver;
	String URL ="https://www.saucedemo.com/";
	
	@BeforeTest
	@Parameters({"browser"})
	public void tearUp(String br) {
		
		switch(br.toLowerCase()) {
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		default: System.out.println("Invalid browser"); return;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);		
	}
	
	@Test(priority=1)
	public void loginTest() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
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

}
