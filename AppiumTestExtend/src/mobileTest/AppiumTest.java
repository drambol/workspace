package mobileTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import testCase.MobileCaseTemplate;
import baseline.AutoContext;
import baseline.SwipeableWebDriver;

public class AppiumTest extends MobileCaseTemplate {
	
	static final Logger logger = LoggerFactory.getLogger(AppiumTest.class);
	public SwipeableWebDriver driver = AutoContext.swipeableWebDriverTL.get();

	@Test
	public void signIn() throws InterruptedException {
		if (driver == null) {
			driver = AutoContext.swipeableWebDriverTL.get();
		}
		WebElement acceptButton = driver.findElement(By.name("Accept"));
		acceptButton.click();
		WebElement signInButton = driver.findElement(By.name("Sign in to Mozy"));
		signInButton.click();
		driver.findElement(By.name("Email address")).sendKeys("kenx2015@emc.com");
		driver.findElements(By.className("android.widget.EditText")).get(1).sendKeys("88888888");
		driver.findElement(By.name("Sign In")).click();
		try {
			logger.info("Now clicking Progress Bar to stop loading...");
			Thread.sleep(20000);
			driver.findElement(By.className("android.widget.ProgressBar")).click();
		} catch(NoSuchElementException e) {
			logger.info("Process bar not found, continue running scripts...");
		}
		driver.findElement(By.name("No"), 20).click();
		//Assert "All Files" tab is displayed on the screen.
		Assert.assertEquals(driver.findElement(By.name("All Files")).isDisplayed(), true);
	}

}
