package test.move;

import org.testng.annotations.Test;

import business.AELoginBusiness;
import business.AddBillerBusiness;
import test.BaseCaseTemplate;

public class AddBillerTest extends BaseCaseTemplate{
	
	@Test
	public void AddBiller() {
		
		AELoginBusiness aeLoginBusiness = new AELoginBusiness();
		aeLoginBusiness.AELogin();
		
		AddBillerBusiness addBillerBusiness = new AddBillerBusiness();
		addBillerBusiness.SelectBillerType();
	}
}
