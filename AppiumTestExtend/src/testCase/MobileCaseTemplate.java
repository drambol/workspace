package testCase;

import java.net.URL;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utility.file.EnvironmentVariable;
import utility.file.XmlParser;
import utility.system.AppiumService;
import utility.system.WindowsProcess;
import utility.system.android.TestData;
import baseline.AutoContext;
import baseline.SwipeableWebDriver;

public class MobileCaseTemplate {

	static final Logger logger = LoggerFactory.getLogger(MobileCaseTemplate.class);
	protected SwipeableWebDriver driver;
	private String testCaseName;
	private String cmdCommand;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		driver = AutoContext.swipeableWebDriverTL.get();
		testCaseName = this.getClass().getSimpleName();
		
		//New a SwipeableWebDriver if the driver not found
		if (driver == null) {
			//Set up appium
			TestData.prepareApk();
			XmlParser xmlParser = new XmlParser("runSuite\\MobileConfig.xml");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.VERSION, "4.2.2");
			capabilities.setCapability("app", EnvironmentVariable.getApkLocation());
			capabilities.setCapability("platformName", xmlParser.getNodeValue("platformName"));
			capabilities.setCapability("deviceName", xmlParser.getNodeValue("deviceName"));
			capabilities.setCapability("app-package", xmlParser.getNodeValue("app-package"));
			capabilities.setCapability("app-activity", xmlParser.getNodeValue("app-activity"));
			cmdCommand = "cmd /c emulator -avd " + xmlParser.getNodeValue("deviceName");
			
			//Create an emulator
			WindowsProcess.killProcess("emulator-arm.exe");
			WindowsProcess.killProcess("node.exe");
			logger.info("Automation will create a new emulator: " + xmlParser.getNodeValue("deviceName"));
			cmdCommand = "cmd /c emulator -avd " + xmlParser.getNodeValue("deviceName");
			WindowsProcess.runProcess(cmdCommand, 60);
			
			logger.info("Try to create new Appium driver...");
			for (int i = 0; i < 3; i++) {
				try {
					driver = new SwipeableWebDriver(new URL(xmlParser.getNodeValue("url")), capabilities);
					Thread.sleep(3000);
					break;
				} catch (UnreachableBrowserException e1) { //Restart appium service.
					AppiumService.restart(i);
					logger.info("UnreachableBrowserException, wait Appium service to start... Count " + i);
				} catch (SessionNotCreatedException e2) {
					logger.info("Automation is encountering SessionNotCreatedException... Count " + i);
				}
			}
		}

		AutoContext.swipeableWebDriverTL.set(driver);
		logger.info("Set driver finished for " + testCaseName);
	}

	@AfterClass(alwaysRun = true)
	public void someBaseTeardown() {
		logger.info("You get the end of the case " + testCaseName);
//		driver.quit();
	}

}
