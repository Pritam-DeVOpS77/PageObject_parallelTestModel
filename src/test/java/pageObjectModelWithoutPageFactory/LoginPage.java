package pageObjectModelWithoutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	// locators
	 By username_loc = By.xpath("//input[@id='user-name']");
	 By password_loc = By.xpath("//input[@id='password']");
	 By subButton_loc = By.xpath("//input[@id='login-button']");

	// Action methods

	public void userNameField(String user) {
		driver.findElement(username_loc).sendKeys(user);
	}

	public void pwdField(String pwd) {
		driver.findElement(password_loc).sendKeys(pwd);
	}

	public void submitButton() {
		driver.findElement(subButton_loc).click();
	}
}
