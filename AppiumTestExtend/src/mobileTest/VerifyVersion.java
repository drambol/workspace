package mobileTest;

import io.appium.java_client.AndroidKeyCode;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import testCase.MobileCaseTemplate;

import baseline.AutoContext;
import baseline.SwipeableWebDriver;

public class VerifyVersion extends MobileCaseTemplate {
	
	static final Logger logger = LoggerFactory.getLogger(VerifyVersion.class);
	public SwipeableWebDriver driver = AutoContext.swipeableWebDriverTL.get();
	private String expectedVersion = "1.6.1";
	
	@Test
	public void verifyVersion() {
		driver = AutoContext.swipeableWebDriverTL.get();
		driver.sendKeyEvent(AndroidKeyCode.MENU);
		driver.findElement(By.name("Settings")).click();
		driver.findElement(By.name("About")).click();
		String appVersion = driver.findElements(By.className("android.widget.TextView")).get(3).getText();
		logger.info("Expected Mozy Version is " + expectedVersion + "; Actual Mozy Version is " + appVersion);
		Assert.assertEquals(appVersion, expectedVersion);
	}

}
