package page.productsAndServices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyActions;
import baseline.MyDriver;
import pageObject.PageLoader;
import pageObject.PageObject;
import utility.dateTime.DateTime;
import utility.file.EnvironmentVariable;

public class BrowseByBrandPage implements PageObject {
	
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(BrowseByBrandPage.class);
	
	public void getCurrentPage() {
		String url = driver.getCurrentUrl();
		if (!url.substring(url.length() - 9, url.length() - 1).equalsIgnoreCase("industry")) {
			driver.get(EnvironmentVariable.getUrl("BrowseByBrandPage"));
			DateTime.sleep(3000);
		}
	}
	
	public BrowseByBrandPage clickIntoBrand(String str) {
		driver.findMyWebElement(By.xpath("//div[text()='" + str + "']")).click();
		return PageLoader.load(BrowseByBrandPage.class);
	}
	
	public BrowseByBrandPage clickIntoFilter(String str) {
		DateTime.sleep(3000);
		driver.findMyWebElement(By.xpath("//a[text()='" + str + "']")).click();
		return PageLoader.load(BrowseByBrandPage.class);
	}
	
	public BrowseByBrandPage clickIntoProducts(String str) {
		DateTime.sleep(3000);
		driver.findMyWebElement(By.xpath("//h3[text()='" + str + "']")).click();
		return PageLoader.load(BrowseByBrandPage.class);
	}
	
	public boolean quicklookAtProduct() {
		try {
			DateTime.sleep(3000);
			MyActions builder = new MyActions(driver.getOriginalDriver());
			WebElement element = driver.findElement(By.xpath("//div[@class='product_div']//img"));
			builder.moveToElement(element).perform();
			driver.findMyWebElement(By.xpath("//div[@class='product_div']/div")).click();
			DateTime.sleep(1000);
			String productName = driver.findMyWebElement(By.xpath("//div[@id='quicklook_header']")).getText();
			logger.info("Quicklook is displayed: " + productName);
			driver.findMyWebElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).click();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
