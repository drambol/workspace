package page;

import java.util.List;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.MyElement;
import pageObject.PageObject;
import utility.database.ExcelUtil;
import utility.file.EnvironmentVariable;

public class CommonPage implements PageObject {
	
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(CommonPage.class);
	protected String testSheet = "CommonPage";
	protected String url = "";
	
	public void verifyAllElements() {
		int rowCount = ExcelUtil.getSheetRowcount(testSheet);
		String testLink = "";
		String xpath = "";
		int xpathCount = 0;
		boolean result = false;
		for(int i = 1; i < rowCount; i++) {
			testLink = EnvironmentVariable.getUrl("BaseURL") + ExcelUtil.getData(testSheet, i, 1);
			if(testLink != url) {
				driver.get(testLink);
				url = testLink;
			}
			xpath = ExcelUtil.getData(testSheet, i, 2);
			xpathCount = Integer.parseInt(ExcelUtil.getData(testSheet, i, 3));
			result = this.getElement(xpath, xpathCount);
			ExcelUtil.writeTestResult(testSheet, i, 4, result);
		}
	}
	
	public void verifyAllElements(String pageName) {
		int rowCount = ExcelUtil.getSheetRowcount(testSheet);
		String testLink = "";
		String xpath = "";
		int xpathCount = 0;
		boolean result = false;
		for(int i = 1; i < rowCount; i++) {
			if (pageName.equals(ExcelUtil.getData(testSheet, i, 0))) {
				testLink = EnvironmentVariable.getUrl("BaseURL") + ExcelUtil.getData(testSheet, i, 1);
				if(testLink != url) {
					driver.get(testLink);
					url = testLink;
				}
				xpath = ExcelUtil.getData(testSheet, i, 2);
				xpathCount = Integer.parseInt(ExcelUtil.getData(testSheet, i, 3));
				result = this.getElement(xpath, xpathCount);
				ExcelUtil.writeTestResult(testSheet, i, 4, result);
			}
		}
	}
	
	private boolean getElement(String xpath, int xpathCount) {
		List<MyElement> elements = driver.findMyWebElements(xpath);
		MyElement element = null;
		if (null == elements) {
			return false;
		}
		try {
			element = elements.get(xpathCount);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return element.exists();
	}
	
	public void temptest() {
		driver.get("http://www.spx.com/en/products-and-services/");
		String spanXPath = "//div[@class='Dot']/span";
		String dotXPath = "//div[@class='Dot']//a";
		List<MyElement> spans = driver.findMyWebElements(By.xpath(spanXPath));
		List<MyElement> dots = driver.findMyWebElements(By.xpath(dotXPath));
		if (spans.get(0).getAttribute("class").equals("psdot current")) {
			dots.get(1).click();
		}
	}
	
	public String verifyNavigation(){
		driver.get("http://www.spx.com/en/literature/");
		MyElement header = driver.findMyWebElement(By.xpath("//div[@id='content_header']"));
		String headerName = "";
		if (header.exists()) {
			headerName = header.getText();
			logger.info("Header is displayed:" + headerName);
			}
		return headerName;
	}

}
