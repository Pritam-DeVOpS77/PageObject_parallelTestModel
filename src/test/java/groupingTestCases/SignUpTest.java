package groupingTestCases;

import org.testng.annotations.Test;

public class SignUpTest {
	@Test (groups={"regression"})
	public void signUpByID() {
		System.out.println("This is Signup test for ID");	
	}
	@Test (groups={"regression"})
	public void signUpByFacebook() {
			System.out.println("This is Signup test for Facebook"); 
	}
	@Test (groups={"regression"})
	public void signUpByGoogle() {
		System.out.println("This is Signup test for Google"); 
	}
}
