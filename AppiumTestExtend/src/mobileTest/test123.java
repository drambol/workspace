package mobileTest;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class test123 {
	
	private AppiumDriver driver;
	static final Logger logger = LoggerFactory.getLogger(AppiumTest.class);
	
	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","AVD_for_Galaxy_Nexus_by_Google");
        capabilities.setCapability("platformVersion", "4.2.2");
        capabilities.setCapability("appPackage", "com.mozy.mobile.android");
        capabilities.setCapability("appActivity", "com.mozy.mobile.android.activities.startup.FirstRun");
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void addContact() throws InterruptedException {
		WebElement acceptButton = driver.findElement(By.name("Accept"));
		acceptButton.click();
		WebElement signInButton = driver.findElement(By.name("Sign in to Mozy"));
		signInButton.click();
		driver.findElement(By.name("Email address")).sendKeys("ken1030@emc.com");
		driver.findElements(By.className("android.widget.EditText")).get(1).sendKeys("test1234");
		driver.findElement(By.name("Sign In")).click();
		try {
			logger.info("Now clicking Progress Bar to stop loading...");
			Thread.sleep(20000);
			driver.findElement(By.className("android.widget.ProgressBar")).click();
		} catch(NoSuchElementException e) {
			logger.info("Process bar not found, continue running scripts...");
		}
		driver.findElement(By.name("No")).click();
		//Assert "All Files" tab is displayed on the screen.
		Assert.assertEquals(driver.findElement(By.name("All Files")).isDisplayed(), true);
	}
	
}
