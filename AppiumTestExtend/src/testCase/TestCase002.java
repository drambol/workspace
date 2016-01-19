package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import testCase.BaseCaseTemplate;
import utility.database.ExcelUtil;

import page.HomePage;
import pageObject.PageLoader;

public class TestCase002 extends BaseCaseTemplate {
	
	@Test
	public void topNaviTest() {
		HomePage homePage = PageLoader.load(HomePage.class);
		homePage.getCurrentPage();
		String[] args = homePage.verifyTopNavigation();
		Assert.assertEquals(args[0], "our company");
		Assert.assertEquals(args[1], "careers");
		Assert.assertEquals(args[2], "investor relations");
		Assert.assertEquals(args[3], "news and events");
		Assert.assertEquals(args[4], "contact us");
		ExcelUtil.writeTestResult("Sheet1", 6, 5, true);
	}
	
	@Test
	public void contactSPXTest() {
		HomePage homePage = PageLoader.load(HomePage.class);
		homePage.getCurrentPage();
		homePage.submitContactSPX();
		//ExcelUtil.writeTestResult("Sheet1", 7, 5, myDriver.hasText("Your message has been received."));
	}

}
