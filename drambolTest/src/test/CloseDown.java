package test;

import org.testng.annotations.Test;

import baseline.AutoContext;

public class CloseDown extends BaseCaseTemplate{
		
	@Test
	public void closeDown() {
		myDriver.quit();
		AutoContext.myWebDriverTL.set(null);
	}

}
