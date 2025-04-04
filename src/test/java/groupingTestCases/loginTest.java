package groupingTestCases;

import org.testng.annotations.Test;

public class loginTest {
	
	@Test (groups={"sanity"})
	public void loginUpByID() {
		System.out.println("This is login test for ID");	
	}
	@Test (groups={"sanity"})
	public void loginByFacebook() {
			System.out.println("This is login test for Facebook"); 
	}
	
	@Test (groups={"sanity"})
	public void loginByGoogle() {
		System.out.println("This is login test for Google"); 
	}

}
