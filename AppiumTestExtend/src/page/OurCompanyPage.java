package page;

import java.util.List;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.MyElement;
import pageObject.PageLoader;
import pageObject.PageObject;
import utility.database.ExcelUtil;
import utility.dateTime.DateTime;
import utility.file.EnvironmentVariable;

public class OurCompanyPage implements PageObject {
	
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(OurCompanyPage.class);
	protected String testSheet = "OurcompanyPage";
	
	public void getCurrentPage() {
		String url = driver.getCurrentUrl();
		if (!url.substring(url.length() - 9, url.length() - 1).equalsIgnoreCase("-company")) {
			driver.get(EnvironmentVariable.getUrl("OurCompanyPage"));
			DateTime.sleep(1000);
		}
	}
	
	public OurCompanyPage navigateTo(String str) {
		driver.findMyWebElement(By.xpath("//a[text()='" + str + "']")).click();
		return PageLoader.load(OurCompanyPage.class);
	}
	
	public void verifyElements() {
		MyElement contentHeader = driver.findMyWebElement(By.xpath(ExcelUtil.getData(testSheet, 1, 1)));
		MyElement leftNavigation = driver.findMyWebElement(By.xpath(ExcelUtil.getData(testSheet, 2, 1)));
		MyElement featuredLinks = driver.findMyWebElement(By.xpath(ExcelUtil.getData(testSheet, 3, 1)));
		MyElement printIcon = driver.findMyWebElement(By.xpath(ExcelUtil.getData(testSheet, 4, 1)));
		MyElement socialIcon = driver.findMyWebElement(By.xpath(ExcelUtil.getData(testSheet, 5, 1)));
		
		if (contentHeader.exists()) {
			String headerName = contentHeader.findMyWebElement(By.xpath("div")).getText();
			logger.info("Content Header is displayed: " + headerName);
		}
		ExcelUtil.writeTestResult(testSheet, 1, 2, contentHeader.exists());
		
		if (leftNavigation.exists()) {
			List<MyElement> expanders = driver.findMyWebElements(By.xpath("//span[@class='expander']"));
			expanders.get(1).click();
			expanders.get(0).click();
			List<MyElement> navis = leftNavigation.findMyWebElements(By.xpath("ul[@id='left-nav']//a"));
			for (int i = 0; i < navis.size(); i++) {
				logger.info("Find left navigation: " + navis.get(i).getText());
			}
		}
		ExcelUtil.writeTestResult(testSheet, 2, 2, leftNavigation.exists());
		
		if (featuredLinks.exists()) {
			List<MyElement> links = featuredLinks.findMyWebElements(By.xpath("ul[@class='related_links']//a"));
			for (int i = 0; i < links.size(); i++) {
				logger.info("Find featured link: " + links.get(i).getText());
			}
		}
		ExcelUtil.writeTestResult(testSheet, 3, 2, featuredLinks.exists());
		
		if (printIcon.exists()) {
			logger.info("Print icon is displayed.");
		}
		ExcelUtil.writeTestResult(testSheet, 4, 2, printIcon.exists());
		
		if (socialIcon.exists()) {
			logger.info("Social icon is displayed.");
		}
		ExcelUtil.writeTestResult(testSheet, 5, 2, socialIcon.exists());
	}
	
	public void verifyBreadcrumbs() {
		MyElement breadcrumbs = driver.findMyWebElement(By.xpath(ExcelUtil.getData(testSheet, 6, 1)));
		if (breadcrumbs.exists()) {
			logger.info("Breadcrumbs section is displayed.");
		}
		List<MyElement> parentMenus = breadcrumbs.findMyWebElements(By.xpath("p//a"));
		for (int i = 0; i < parentMenus.size(); i++) {
			breadcrumbs = driver.findMyWebElement(By.xpath(ExcelUtil.getData(testSheet, 6, 1)));
			parentMenus = breadcrumbs.findMyWebElements(By.xpath("p//a"));
			String href = parentMenus.get(i).getAttribute("href");
			logger.info("[Breadcrumbs section] Click " + parentMenus.get(i).getText() + " link..." );
			parentMenus.get(i).click();
			boolean result = driver.getCurrentUrl().contains(href);
			ExcelUtil.writeTestResult(testSheet, 6, 2, result);
			driver.navigate().back();
			PageLoader.load(OurCompanyPage.class);
			if (!result)
				return;
		}
	}
	
	public void test() {
		String url = "http://joanfernandez.es/";
		driver.get(url);
		driver.findMyWebElement("//*[@id='top-navigation']/ul/li[2]/a").click();
		
	}

}
