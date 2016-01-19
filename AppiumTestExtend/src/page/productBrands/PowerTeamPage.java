package page.productBrands;

import java.util.List;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.MyElement;
import pageObject.PageObject;
import utility.database.ExcelUtil;
import utility.dateTime.DateTime;
import utility.file.EnvironmentVariable;

public class PowerTeamPage implements PageObject {
	
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(PowerTeamPage.class);
	
	public void getCurrentPage() {
		String url = driver.getCurrentUrl();
		if (!url.substring(url.length() - 11, url.length() - 1).equalsIgnoreCase("power-team")) {
			driver.get(EnvironmentVariable.getUrl("PowerTeamPage"));
			DateTime.sleep(3000);
		}
	}
	
	public void verifyNavigatoin() {
		String navigationName = "";
		String navigationLink = "";
		List<MyElement> expanders = driver.findMyWebElements(By.xpath("//div[@id='navigation_sidebar']//span[@class='expander']"));
		List<MyElement> navigations = driver.findMyWebElements(By.xpath("//div[@id='navigation_sidebar']//a"));
		expanders.get(7).click();
		for (int i = 0; i < 7; i++) {
			expanders.get(i).click();
		}
		for (int i = 8; i < expanders.size(); i++) {
			expanders.get(i).click();
		}
		for (int j = 0; j < navigations.size(); j++) {
			navigationName = navigations.get(j).getText();
			navigationLink = navigations.get(j).getAttribute("href");
			logger.info(navigationName + ": " + navigationLink);
			if (ExcelUtil.getData("PowerteamPage", j + 1, 0).equalsIgnoreCase(navigationName)) {
				boolean result = navigationLink.contains(ExcelUtil.getData("PowerteamPage", j + 1, 1));
				ExcelUtil.writeTestResult("PowerteamPage", j + 1, 2, result);
			}
		}
		driver.get(EnvironmentVariable.getUrl("PowerTeamPage"));
	}
	
	public void verifyImageRotate() {
		List<MyElement> images = driver.findMyWebElements(By.xpath(ExcelUtil.getData("PowerteamPage", 1, 6)));
		List<MyElement> learnmoreLinks = driver.findMyWebElements(By.xpath(ExcelUtil.getData("PowerteamPage", 2, 6)));
		int timer = 0;
		for (int i = 0; i < 5; i++) {
			DateTime.sleep(500);
			timer = timer + 1;
			if (timer == 600) {
				logger.info("Failed to rotate image in Power Team Page!");
				ExcelUtil.writeTestResult("PowerteamPage", 1, 7, false);
			}
			if (images.get(i).getAttribute("style").contains("block")) {
				boolean existance = learnmoreLinks.get(i).exists();
				ExcelUtil.writeTestResult("PowerteamPage", i + 2, 7, existance);
				String info = "NOT displayed";
				if (existance)
					info = "displayed";
				switch (i) {
				case 0:
					logger.info("[Rotate Image in Power Team Page] The 1st image is displayed!");
					logger.info("[Verify Learn More Link] Learn More Link is " + info + " for the 1st image!");
					break;
				case 1:
					logger.info("[Rotate Image in Power Team Page] The 2nd image is displayed!");
					logger.info("[Verify Learn More Link] Learn More Link is " + info + " for the 2nd image!");
					break;
				case 2:
					logger.info("[Rotate Image in Power Team Page] The 3rd image is displayed!");
					logger.info("[Verify Learn More Link] Learn More Link is " + info + " for the 3rd image!");
					break;
				case 3:
					logger.info("[Rotate Image in Power Team Page] The 4th image is displayed!");
					logger.info("[Verify Learn More Link] Learn More Link is " + info + " for the 4th image!");
					break;
				case 4:
					logger.info("[Rotate Image in Power Team Page] The 5th image is displayed!");
					logger.info("[Verify Learn More Link] Learn More Link is " + info + " for the 5th image!");
					break;
				}
			} else {
				i--;
			}
		}
		ExcelUtil.writeTestResult("PowerteamPage", 1, 7, true);
	}
	
	public void verifyLearnmoreLinks() {
		List<MyElement> learnmoreLinks = driver.findMyWebElements(By.xpath(ExcelUtil.getData("PowerteamPage", 2, 6)));
		for (int i = 5; i < 8; i++) {
			boolean existance = learnmoreLinks.get(i).exists();
			ExcelUtil.writeTestResult("PowerteamPage", i + 2, 7, existance);
			String info = "NOT displayed";
			if (existance)
				info = "displayed";
			int num = i + 1;
			logger.info("[Verify Learn More Link] Learn More Link is " + info + " for the " + num + "th image!");
		}
	}
	
	public void verifyExplorePopup() {
		String info = "NOT displayed!";
		driver.findMyWebElement(By.xpath(ExcelUtil.getData("PowerteamPage", 10, 6))).click();
		boolean exist1 = driver.findMyWebElement(By.xpath(ExcelUtil.getData("PowerteamPage", 11, 6))).exists();
		boolean exist2 = driver.findMyWebElement(By.xpath(ExcelUtil.getData("PowerteamPage", 12, 6))).exists();
		boolean exist3 = driver.findMyWebElement(By.xpath(ExcelUtil.getData("PowerteamPage", 13, 6))).exists();
		ExcelUtil.writeTestResult("PowerteamPage", 11, 7, exist1);
		ExcelUtil.writeTestResult("PowerteamPage", 12, 7, exist2);
		ExcelUtil.writeTestResult("PowerteamPage", 13, 7, exist3);
		if (exist1)
			info = "displayed!";
		logger.info("[Verify Explore] Popup window is " + info);
		info = "NOT displayed!";
		if (exist2)
			info = "displayed!";
		logger.info("[Verify Explore] Pagination Icon is " + info);
		info = "NOT displayed!";
		if (exist3)
			info = "displayed!";
		logger.info("[Verify Explore] Close Icon is " + info);
	}

}
