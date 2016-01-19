package testCase;

import org.testng.annotations.Test;
import testCase.BaseCaseTemplate;
import utility.database.ExcelUtil;

import page.CommonPage;
import page.HomePage;
import page.NewsAndEventsPage;
import page.OurCompanyPage;
import page.productBrands.PowerTeamPage;
import page.productsAndServices.BrowseByBrandPage;
import pageObject.PageLoader;

public class TestCase003 extends BaseCaseTemplate {
	
	@Test
	public void homepageNavigationTest(){
		HomePage homePage = PageLoader.load(HomePage.class);
		homePage.getCurrentPage();
		String testSheet = "Homepage";
		int rowcount = ExcelUtil.getSheetRowcount(testSheet);
		boolean testResult = false;
		for (int i=1;i<rowcount;i++){
			String navigationName = ExcelUtil.getData(testSheet, i, 0);
			if ("".equals(navigationName)) {
				String droplistName = ExcelUtil.getData(testSheet, i, 1);
				testResult = homePage.getNavigationHref(droplistName).contains(ExcelUtil.getData(testSheet, i, 2));
			} else {
				testResult = homePage.getNavigationHref(navigationName).contains(ExcelUtil.getData(testSheet, i, 2));
			}
			ExcelUtil.writeTestResult(testSheet, i, 3, testResult);
		}
	}
	
	@Test
	public void headerBarTest() {
		HomePage homePage = PageLoader.load(HomePage.class);
		homePage.getCurrentPage();
		homePage.headerBarTest();
		ExcelUtil.writeTestResult("Sheet1", 8, 5, true);
	}
	
	@Test
	public void BrowseByBrandPageTest() {
		BrowseByBrandPage browseByBrandPage = PageLoader.load(BrowseByBrandPage.class);
		browseByBrandPage.getCurrentPage();
		browseByBrandPage.clickIntoBrand("APV");
		browseByBrandPage.clickIntoFilter("Food and Beverage");
		browseByBrandPage.clickIntoProducts("heat exchangers");
		boolean result = browseByBrandPage.quicklookAtProduct();
		ExcelUtil.writeTestResult("Sheet1", 9, 5, result);
	}
	
	@Test
	public void PowerteamPageTest() {
		PowerTeamPage powerTeamPage = PageLoader.load(PowerTeamPage.class);
		powerTeamPage.getCurrentPage();
		powerTeamPage.verifyNavigatoin();
		powerTeamPage.verifyImageRotate();
		powerTeamPage.verifyLearnmoreLinks();
		powerTeamPage.verifyExplorePopup();
	}
	
	@Test
	public void OurCompanyPageTest() {
		OurCompanyPage ourCompanyPage = PageLoader.load(OurCompanyPage.class);
		ourCompanyPage.getCurrentPage();
		ourCompanyPage.navigateTo("strategy and structure");
		ourCompanyPage.verifyElements();
		ourCompanyPage.verifyBreadcrumbs();
	}
	
	@Test
	public void NewsAndEventsPageTest() {
		NewsAndEventsPage newsAndEventsPage = PageLoader.load(NewsAndEventsPage.class);
		newsAndEventsPage.getCurrentPage();
		newsAndEventsPage.navigateTo("tradeshow schedule");
		newsAndEventsPage.getAllEvents();
		newsAndEventsPage.expandEvents();
		newsAndEventsPage.searchEvents("China");
		newsAndEventsPage.getPage("power-team/");
	}
	
	@Test
	public void CommonPageTest() {
		CommonPage commonPage = new CommonPage();
		commonPage.verifyAllElements();
	}

}
