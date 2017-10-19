package test.selfTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import listener.WebEventListener;
import utility.file.EnvironmentVariable;

public class EventListenerExample {
	private WebDriver driver;
	public static EventFiringWebDriver e_driver;
	private WebEventListener eventListener;
	public int waitTime = 10;
	
	public WebDriver getDriver() {
		return driver;
	}

	@BeforeClass()
	public void setUp() {

		// Initializing instance of chrome driver
		driver = null;
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("start-maximized");
		System.setProperty("webdriver.chrome.driver", EnvironmentVariable.getChromeLocation());
		driver = new ChromeDriver(options);

		// Initializing EventFiringWebDriver using Firefox WebDriver instance
		e_driver = new EventFiringWebDriver(driver);
		
		// Create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		
	}

	@AfterClass()
	public void tearDown() {
		if (e_driver != null) {
			e_driver.quit();
		}
	}

}
