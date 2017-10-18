package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.Scenario;
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
	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String fileName = DateTime.getCurrentTime() + ".png";
			File desfile = new File(System.getProperty("user.dir") + "\\screenshot\\" + fileName);
			desfile.getParentFile().mkdirs();
			try {
				FileUtils.copyFile(scrFile, desfile);
				System.out.println("***Placed screen shot in " + System.getProperty("user.dir") + "\\screenshot\\"
						+ fileName + " ***");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		driver.close();
		driver.quit();
	}

}
