package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseline.AutoContext;
import baseline.MyDriver;
import baseline.WebDriverCreator;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import page.Authenticate2FAPage;
import page.LoginPage;
import pageObject.PageLoader;
import utility.dateTime.DateTime;

public class StartUpSteps {
	protected MyDriver myDriver;
	private LoginPage loginPage;
	private Authenticate2FAPage authenticate2FAPage;

	@Given("^User go to Login Page$")
	public void getLoginPage() throws Throwable {
		loginPage.getCurrentPage();
	}

	@Given("^User go to 2FA Page$")
	public void get2FApage() throws Throwable {
		authenticate2FAPage.get2FAPage();
	}

	@Before
	public void startUp() throws IOException, InterruptedException {
		myDriver = AutoContext.myWebDriverTL.get();
		if (myDriver == null) {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			myDriver = (MyDriver) WebDriverCreator.create();
			myDriver.maximizeWindow();
		}
		AutoContext.myWebDriverTL.set(myDriver);
		loginPage = PageLoader.load(LoginPage.class);
		authenticate2FAPage = PageLoader.load(Authenticate2FAPage.class);
	}

	@After
	public void embedScreenshot(Scenario scenario) {
		MyDriver myDriver = AutoContext.myWebDriverTL.get();
		if (scenario.isFailed()) {
			File scrFile = ((TakesScreenshot) myDriver.getOriginalDriver()).getScreenshotAs(OutputType.FILE);
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
	}

}
