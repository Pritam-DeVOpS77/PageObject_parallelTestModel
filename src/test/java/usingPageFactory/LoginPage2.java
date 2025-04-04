package usingPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage2 {
	
	WebDriver driver;
	
	LoginPage2(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators
	@FindBy(xpath="//input[@id='user-name']")
	WebElement userNameField;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement pwdField;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement LoginButton;
	
	//Another Method using How keyword
	@FindBy(how=How.XPATH, using="//input[@id='login-button']")
	WebElement LoginButton1;
	
	//Action Methods
	public void UserName(String user) {
		userNameField.sendKeys(user);
	}
	
    public void pwd(String password) {
    	pwdField.sendKeys(password);
	}
	
    public void SubmitButton() {
    	LoginButton.click();
	}
    
}
