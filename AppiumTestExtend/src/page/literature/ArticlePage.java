package page.literature;

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

public class ArticlePage implements PageObject{
	
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(ArticlePage.class);
	
	public boolean verifyStoryExists() {
		List<MyElement> storys = driver.findMyWebElements(By.xpath(ExcelUtil.getElementXpath("Sheet1", "article story")));
		for (int j = 0; j < storys.size(); j++) {
			if (!storys.get(j).getText().toString().isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	public String getHeaderName(){
		MyElement header = driver.findMyWebElement(By.xpath("//div[@id='content_header']"));
		String headerName = "";
		if (header.exists()) {
			headerName = header.getText();
			logger.info("Header is displayed:" + headerName);
			}
		return headerName;
	}
	
	public void getCurrentPage(String PageName) {
		String testLink = "";
		String url = driver.getCurrentUrl();
		if (!url.substring(url.length() - 9, url.length() - 1).equalsIgnoreCase("literature")) {
			testLink = EnvironmentVariable.getUrl("BaseURL") + PageName + "/";
			logger.info("testlink is " + testLink);
			driver.get(testLink);
			DateTime.sleep(1000);
		}
	}
	
	public boolean verifyNavigation() {
		boolean result = false;
		String naviXpath = "//ul[@id='left-nav']//a";
		List<MyElement> elements = driver.findMyWebElements(By.xpath(naviXpath));
		int size = elements.size();
		logger.info("Size is " + size);
		for (int i = 0; i < size; i++) {
			String URL = elements.get(i).getAttribute("href");
			logger.info("Navigation item's URL is " + URL);
			if (URL != null) {
				logger.info("Navigation item's text is " + elements.get(i).getText());
			} else {
				logger.info("Left Navigation displays correctly");
				return result;
			}
		}
		result = true;
		return result;
	}
	
	
	public ArticlePage navigateTo(String str, int n) {
		driver.findMyWebElements(By.xpath("//a[text()='" + str + "']")).get(n).click();
		return PageLoader.load(ArticlePage.class);
	}
	
	public boolean verifyBreadcrumbs() {
		boolean result = true;
		MyElement breadcrumbs = driver.findMyWebElement(By.xpath("//div[@id='crumbsWrapper']"));
		if (breadcrumbs.exists()) {
			logger.info("Breadcrumbs section is displayed.");
		}
		int menuCount = breadcrumbs.findMyWebElements(By.xpath("p/a")).size();
		for (int i = 0; i < menuCount; i++) {
			if (result) {
				List<MyElement> parentMenus = driver.findMyWebElements(By.xpath("//div[@id='crumbsWrapper']/p/a"));
				String href = parentMenus.get(i).getAttribute("href");
				logger.info("[Breadcrumbs section] Click " + parentMenus.get(i).getText() + " link...");
				parentMenus.get(i).click();
				result = driver.getCurrentUrl().contains(href);
				driver.navigate().back();
				PageLoader.load(ArticlePage.class);
			} else {
				return result;
			}
		}
		return result;
	}
	
	public boolean verifyContainer(){
		boolean result = true;
		MyElement title1 = driver.findMyWebElement(By.xpath("//*[@id='finder_content']//h1/span"));
		String titleText = title1.getText();
		if(titleText.equals("")){
			logger.info("Title don't display.");
			return result;
		}
		logger.info("Title is " + titleText);
		List<MyElement> parentMenus = driver.findMyWebElements(By.xpath("//div[@class ='columnListItems']"));
		int size = parentMenus.size();
		for(int i=0; i<size; i++){
			MyElement subtitle = parentMenus.get(i).findMyWebElement(By.xpath("div[@class ='columnListTitle']"));
			String title2 = parentMenus.get(i).findMyWebElement(By.xpath("div[@class ='columnListTitle']")).getText();
			if(subtitle.exists()){
			logger.info("Sub-Title display :" + title2);
			}
			List<MyElement> itemList = parentMenus.get(i).findMyWebElements(By.xpath("div[class='columnItem']"));
			result = getColumnItem(itemList);
			if(!result){
				logger.info("Articles item display incorrectly.");
				return result;
			}
		}
		return result;		
	}
	
	public boolean getColumnItem(List<MyElement> driver1){
		boolean result = false;
		for(int i = 0; i<driver1.size();i++){
			String itemDesc = driver1.get(i).findMyWebElement(By.xpath("div/div/p")).toString(); 
			if(itemDesc.equals("")){
				return result;
			}
		}
		result = true;
		return result;
	}

}
