package page;

import java.util.List;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;

import page.literature.ArticlePage;
import pageObject.MyElement;
import pageObject.PageLoader;
import pageObject.PageObject;
import utility.database.ExcelUtil;
import utility.dateTime.DateTime;
import utility.file.EnvironmentVariable;

public class HomePage implements PageObject{
	
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(HomePage.class);
	
	public void getCurrentPage() {
		String url = driver.getCurrentUrl();
		if (!url.substring(url.length() - 3, url.length() - 1).equalsIgnoreCase("en")) {
			driver.get(EnvironmentVariable.getUrl("HomePage"));
			DateTime.sleep(3000);
		}
	}
	
	public double getRotateInterval() {
		double interval = 0;
		List<MyElement> elements = driver.findMyWebElements(By.xpath(ExcelUtil.getElementXpath("Sheet1", "slide dot")));
		for (int i = 0; i < 300; i++) {
			if ("dot greendot".equalsIgnoreCase(elements.get(1).getAttribute("class").toString())) {
				DateTime.sleep(100);
				for (int p = 1; p < 310; p++) {
					if ("dot greendot".equalsIgnoreCase(elements.get(2).getAttribute("class").toString())) {
						interval = (double)p/10;
						logger.info("[Rotate Test] Rotate Interval is " + interval + " seconds!");
						return interval;
					} else {
						DateTime.sleep(100);
					}
				}
			} else {
				DateTime.sleep(100);
			}
		}
		logger.info("Test case failed due to unable to rotate images in 30 seconds.");
		return interval;
	}
	
	public void rotateAllImages() {
		List<MyElement> elements = driver.findMyWebElements(By.xpath(ExcelUtil.getElementXpath("Sheet1", "slide dot")));
		for (int i = 0; i < elements.size(); i++) {
			DateTime.sleep(1000);
			if ("dot greendot".equalsIgnoreCase(elements.get(i).getAttribute("class").toString())) {
				switch (i) {
				case 0:
					logger.info("[Rotate Test] The 1st image is displayed!");
					break;
				case 1:
					logger.info("[Rotate Test] The 2nd image is displayed!");
					break;
				case 2:
					logger.info("[Rotate Test] The 3rd image is displayed!");
					break;
				case 3:
					logger.info("[Rotate Test] The 4th image is displayed!");
					break;
				case 4:
					logger.info("[Rotate Test] The 5th image is displayed!");
					break;
				}
			} else {
				i--;
			}
		}
	}
	
	public int getSpotlightArticleCount() {
		List<MyElement> elements = driver.findMyWebElements(By.xpath(ExcelUtil.getElementXpath("Sheet1", "spotlight image")));
		return elements.size();
	}
	
	public ArticlePage clickSpotlightArticle(int i) {
		this.getCurrentPage();
		List<MyElement> elements = driver.findMyWebElements(By.xpath(ExcelUtil.getElementXpath("Sheet1", "spotlight image")));
		String elementName = elements.get(i).getAttribute("src").toString();
		logger.info("[Spotlight] Now click into Spotlight: " + elementName);
		elements.get(i).click();
		return PageLoader.load(ArticlePage.class);
	}
	
	public int getNewsListCount() {
		this.getCurrentPage();
		List<MyElement> news = driver.findMyWebElements(By.xpath(ExcelUtil.getElementXpath("Sheet1", "news list")));
		logger.info("[News List] There exists " + news.size() + " news list(s).");return news.size();
	}
	
	public boolean clickNewsList() {
		boolean flag = true;
		int newsListCount = this.getNewsListCount();
		for (int i = 0; i < newsListCount; i++) {
			this.getCurrentPage();
			List<MyElement> newsLinks = driver.findMyWebElements(By.xpath(ExcelUtil.getElementXpath("Sheet1", "news list link")));
			newsLinks.get(i).click();
			logger.info("[News List] Open URL: " + driver.getCurrentUrl());
			if (driver.getCurrentUrl().contains("news-and-events")){
				logger.info("[News List] Verified the current url contains 'news-and-events'!");
			} else {
				logger.info("[News List] The current url DOES NOT contain 'news-and-events'!");
				flag = false;
			}
		}
		return flag;
	}
	
	public String[] verifyTopNavigation() {
		List<MyElement> topNavis = driver.findMyWebElements(By.xpath(ExcelUtil.getElementXpath("Sheet1", "top navigation")));
		String[] args = new String[topNavis.size()];
		for (int i = 0; i < topNavis.size(); i++) {
			args[i] = topNavis.get(i).getText();
			logger.info("[Top Navigation]: " + topNavis.get(i).getAttribute("href"));
		}
		return args;
	}
	
	public void submitContactSPX() {
		driver.findMyWebElements(By.xpath(ExcelUtil.getElementXpath("Sheet1", "top navigation"))).get(4).click();
		DateTime.sleep(2000);
		driver.findMyWebElement(By.xpath(ExcelUtil.getElementXpath("Sheet2", "first name"))).input(ExcelUtil.getExpectedResult("Sheet2", "first name"));
		driver.findMyWebElement(By.xpath(ExcelUtil.getElementXpath("Sheet2", "last name"))).input(ExcelUtil.getExpectedResult("Sheet2", "last name"));
		driver.findMyWebElement(By.xpath(ExcelUtil.getElementXpath("Sheet2", "email"))).input(ExcelUtil.getExpectedResult("Sheet2", "email"));
		driver.findMyWebElement(By.xpath(ExcelUtil.getElementXpath("Sheet2", "phone"))).input(ExcelUtil.getExpectedResult("Sheet2", "phone"));
		driver.findMyWebElement(By.xpath(ExcelUtil.getElementXpath("Sheet2", "zipcode"))).input(ExcelUtil.getExpectedResult("Sheet2", "zipcode"));
		driver.findMyWebElement(By.xpath(ExcelUtil.getElementXpath("Sheet2", "country"))).select(ExcelUtil.getExpectedResult("Sheet2", "country"));
		driver.findMyWebElement(By.xpath(ExcelUtil.getElementXpath("Sheet2", "type of inquiry"))).select(ExcelUtil.getExpectedResult("Sheet2", "type of inquiry"));
		driver.findMyWebElement(By.xpath(ExcelUtil.getElementXpath("Sheet2", "brand"))).select(ExcelUtil.getExpectedResult("Sheet2", "brand"));
		driver.findMyWebElement(By.xpath(ExcelUtil.getElementXpath("Sheet2", "message"))).input(ExcelUtil.getExpectedResult("Sheet2", "message"));
		driver.findMyWebElement(By.xpath(ExcelUtil.getElementXpath("Sheet2", "submit"))).click();
	}
	
	public String getNavigationHref(String name) {
		MyElement myElement = driver.findMyWebElement(By.xpath("//a[text()='" + name + "']"));
		logger.info(name + ": " + myElement.getAttribute("href"));
		return myElement.getAttribute("href");
	}
	
	public boolean headerBarTest() {
		boolean result = false;
		logger.info("Now will scroll the page to buttom.");
		driver.executeScript("scrollTo(0, 3000)");
		MyElement headerBar = driver.findMyWebElement(By.xpath(ExcelUtil.getElementXpath("Sheet1", "header bar")));
		if (headerBar.exists()) {
			logger.info("Header bar is displayed.");
			DateTime.sleep(2500);
			driver.findMyWebElement(By.xpath("//div[@class='footer_top']")).click();
			if (!driver.judgeElementExistance(headerBar)) {
				logger.info("Header bar is hidden.");
				result = true;
			}
		} else {
			logger.info("Header bar is NOT displayed.");
			return result;
		}
		return result;
	}

}
