package test;

import org.testng.annotations.Test;

import business.AELoginBusiness;
import business.AddBillerBusiness;

public class AELoginTest extends BaseCaseTemplate {

	@Test
	public void loginTest() {
		
//		prepareTestReport(new Object(){}.getClass().getEnclosingMethod().getName());
		
		AELoginBusiness aeLoginBusiness = new AELoginBusiness();
		aeLoginBusiness.AELogin();
		aeLoginBusiness.verifyLoginSuccess();
		OTPTable.retrieveOTP();

		System.out.println("Login Successfully");	
		
		AddBillerBusiness addBillerBusiness = new AddBillerBusiness();
		addBillerBusiness.goToMove();

	}
}
