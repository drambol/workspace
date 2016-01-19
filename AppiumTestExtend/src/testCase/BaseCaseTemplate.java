package testCase;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utility.file.TestResult;

import baseline.AutoContext;
import baseline.MyDriver;
import baseline.WebDriverCreator;

public class BaseCaseTemplate {
	
	protected MyDriver myDriver;
	private String testCaseName;
	
	@BeforeClass(alwaysRun = true)
	public void setupBrowser(){
		
		myDriver = AutoContext.myWebDriverTL.get();
		testCaseName = this.getClass().getSimpleName();

//		Dimension d = new Dimension(200, 500);
//		myDriver.getOriginalDriver().manage().window().setSize(d);
		
		if (myDriver == null) {
			myDriver = (MyDriver) WebDriverCreator.create();
			myDriver.maximizeWindow();
		}
		
		// Put into thread
		AutoContext.myWebDriverTL.set(myDriver);
	}
	
	@AfterClass(alwaysRun = true)
	public void someBaseTeardown() {
		System.out.println("You get the end of the case " + testCaseName);
//		myDriver.quit();
	}
	
	public void closeDown() {
		try {
			TestResult.storeTestResult();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myDriver.quit();
		AutoContext.webDriverTL.set(null);
		AutoContext.myWebDriverTL.set(null);
	}

}
