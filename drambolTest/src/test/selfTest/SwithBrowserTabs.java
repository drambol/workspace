package test.selfTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseline.AutoContext;
import baseline.MyDriver;
import test.BaseCaseTemplate;

public class SwithBrowserTabs extends BaseCaseTemplate{
		static final Logger logger = LoggerFactory.getLogger(SwithBrowserTabs.class);
		
		@Test
		public void testBaiDu() throws SQLException, IOException {

			logger.info("start chrome");
			MyDriver driver = AutoContext.myWebDriverTL.get();
			driver.get("http://www.baidu.com/");
			
			logger.info("open another tab");
			JavascriptExecutor jse = (JavascriptExecutor) (driver);
			jse.executeScript("window.open(arguments[0])", "http://www.google.com/");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			WebElement googletxtbox = driver.findMyWebElement(By.id("lst-ib"));
			googletxtbox.sendKeys("StandardChartered");
			driver.close();
			
			logger.info("return to first tab");
			driver.switchTo().window(tabs.get(0));
			WebElement txtbox = driver.findMyWebElement(By.name("wd"));
			txtbox.sendKeys("StandardChartered");
			WebElement btn = driver.findMyWebElement(By.id("su"));
			btn.click();

			Assert.assertEquals(driver.findMyWebElement(By.xpath("//div[@id='1']/h3/a/em")).getText(), "Standard Chartered",
					"test pass");
			
			logger.info("test finished");

		}
}
