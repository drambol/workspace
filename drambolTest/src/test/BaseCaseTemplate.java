package test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utility.file.FileUtility;
import utility.file.TestReport;
import utility.file.XmlParser;
import baseline.AutoContext;
import baseline.MyDriver;
import baseline.WebDriverCreator;
/**
 * 
 * @author Wenjuan.Zhou
 * @Purpose Define test case template
 */
public class BaseCaseTemplate {

	protected MyDriver myDriver;
	private String testCaseName;

	@BeforeClass(alwaysRun = true)
	public void setupBrowser() {

		myDriver = AutoContext.myWebDriverTL.get();
		testCaseName = this.getClass().getSimpleName();
		new TestReport();

		if (myDriver == null) {
			myDriver = WebDriverCreator.create();
			myDriver.manage().window().maximize(); 		
		}

		// Put into thread
		AutoContext.myWebDriverTL.set(myDriver);
	}
	
	@AfterClass(alwaysRun = true)
	public void someBaseTeardown() throws IOException {
		FileUtility.takeScreenshot();
		System.out.println("You get the end of the case " + testCaseName);
		
		// Enable below codes when you want to run each test case on separate chrome driver 
		// otherwise it will use the existing chrome driver
//		myDriver.quit();
//		AutoContext.myWebDriverTL.set(null);
	}
	
	public void prepareTestReport(String str) {
        XmlParser xmlParser = new XmlParser("runSuite\\Config.xml");
        xmlParser.getNodeByName("TestCaseName").setTextContent(str);
        xmlParser.save();
 }


}
