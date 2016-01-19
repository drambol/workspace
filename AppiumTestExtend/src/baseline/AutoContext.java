package baseline;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebDriver;

import pageObject.PageObject;

public class AutoContext {
	public static final ThreadLocal<String[]> userTL = new ThreadLocal<String[]>();
	public static final ThreadLocal<PageObject> pageObjectTL = new ThreadLocal<PageObject>();
	public static final ThreadLocal<WebDriver> webDriverTL = new ThreadLocal<WebDriver>();
	public static final ThreadLocal<MyDriver> myWebDriverTL = new ThreadLocal<MyDriver>();
	public static final ThreadLocal<SwipeableWebDriver> swipeableWebDriverTL = new ThreadLocal<SwipeableWebDriver>();
	public static final ThreadLocal<AppiumDriver> appiumDriverTL = new ThreadLocal<AppiumDriver>();
}