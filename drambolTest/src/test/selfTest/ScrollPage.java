package test.selfTest;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import baseline.AutoContext;
import baseline.MyDriver;
import test.BaseCaseTemplate;
import utility.dateTime.DateTime;

// This demo how to scroll page to a defined element and then take screenshot
public class ScrollPage extends BaseCaseTemplate {

	@Test
	public void testBaiDu() throws SQLException, IOException {

		MyDriver driver = AutoContext.myWebDriverTL.get();

		driver.get("http://www.baidu.com/");
		WebElement txtbox = driver.findElement(By.name("wd"));
		txtbox.sendKeys("StandardChartered");
		WebElement btn = driver.findElement(By.id("su"));
		btn.click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='1']/h3/a/em")).getText(), "Standard Chartered",
				"test pass");
		
		// scroll page to the defined element
		WebElement scroll = driver.findElement(By.xpath("//a[@class ='n']"));
		Actions actions = new Actions(driver.getOriginalDriver());
		actions.moveToElement(scroll);
		actions.perform();
		
		// take screenshot
		File scrFile = ((TakesScreenshot) driver.getOriginalDriver()).getScreenshotAs(OutputType.FILE);
		String fileName = DateTime.getCurrentTime() + ".png";
		File desfile = new File(System.getProperty("user.dir") + "\\screenshot\\" + fileName);
		desfile.getParentFile().mkdirs();
		try {
			FileUtils.copyFile(scrFile, desfile);
			System.out.println("***Placed screen shot in " + System.getProperty("user.dir") + "\\screenshot\\"
					+ fileName + " ***");
			Reporter.log("screenshot path = " + desfile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
