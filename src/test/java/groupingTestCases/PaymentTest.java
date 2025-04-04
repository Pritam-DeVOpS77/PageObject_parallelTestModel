package groupingTestCases;

import org.testng.annotations.Test;

public class PaymentTest {
	
	@Test (groups={"sanity", "regression", "functional"} )
	public void paymentInRupees() {
		System.out.println("This payment method accepts Rupees");
	}
	
	@Test (groups={"sanity", "regression", "functional"} )
	public void paymentInDollars() {
		System.out.println("This payment method accepts Dollars");
	}

}
