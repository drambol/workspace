package test.selfTest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseline.AutoContext;
import baseline.MyDriver;
import utility.calc.MyAssert;

// Enable listener if this is for independent test case. For group test case screenshot, please use TestNG.xml
// @Listeners(ScreenshotListener.class)
public class TestBaiDu extends BaseCaseTemplate {
	@Test
	public void testBaiDu() throws SQLException, IOException {
		
//		prepareTestReport(new Object(){}.getClass().getEnclosingMethod().getName());

		MyDriver driver = AutoContext.myWebDriverTL.get();

		driver.get("http://www.baidu.com/");
		WebElement txtbox = driver.findMyWebElement(By.name("wd"));
		txtbox.sendKeys("StandardChartered");
		WebElement btn = driver.findMyWebElement(By.id("su"));
		btn.click();
		
//		MyAssert.assertEqual(driver.findMyWebElement(By.xpath("//div[@id='1']/h3/a/em")).getText(), "Standard Chartered");
		Assert.assertEquals(driver.findMyWebElement(By.xpath("//div[@id='1']/h3/a/em")).getText(), "Drambol Chartered","test pass");
		System.out.println("test pass");
	}
}
