package testCase;

import org.testng.annotations.Test;
import org.testng.Assert;

import businessFlow.SpotlightFlow;
import testCase.BaseCaseTemplate;
import utility.database.ExcelUtil;

import page.HomePage;
import pageObject.PageLoader;

public class TestCase001 extends BaseCaseTemplate {
	
	@Test
	public void heroStoryTest(){
		HomePage homePage = PageLoader.load(HomePage.class);
		homePage.getCurrentPage();
		homePage.rotateAllImages();
		homePage.getRotateInterval();
		ExcelUtil.writeTestResult("Sheet1", 1, 5, true);
	}
	
	@Test
	public void spotlightTest(){
		SpotlightFlow spotlightFlow = new SpotlightFlow();
		Assert.assertTrue(spotlightFlow.verifyArticles());
		ExcelUtil.writeTestResult("Sheet1", 2, 5, true);
		ExcelUtil.writeTestResult("Sheet1", 3, 5, true);
	}
	
	@Test
	public void newsListTest() {
		HomePage homePage = PageLoader.load(HomePage.class);
		homePage.getCurrentPage();
		int newsListCount = homePage.getNewsListCount();
		Assert.assertTrue(newsListCount <= 4);
		ExcelUtil.writeTestResult("Sheet1", 4, 5, newsListCount <= 4);
		Assert.assertTrue(homePage.clickNewsList());
		ExcelUtil.writeTestResult("Sheet1", 5, 5, true);
	}

}
