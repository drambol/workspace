package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class StartUp {
	public static WebDriver driver;

	@Before
	public WebDriver before() throws IOException {
		 ChromeOptions options = new ChromeOptions();
	     options.setExperimentalOption("useAutomationExtension", false);	
	     options.addArguments("start-maximized");
		 System.setProperty("webdriver.chrome.driver","C:\\Grace\\Useful Matierials\\mine\\Selenium Webdriver\\chromedriver.exe");
		 driver = new ChromeDriver(options);
		 return driver;
	}

	@After
	public void after() {
		driver.close();
		driver.quit();
	}

}
