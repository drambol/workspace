package baseline;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utility.file.EnvironmentVariable;

public class WebDriverCreator {

	public static synchronized MyDriver create() {
		String browserType = EnvironmentVariable.getBrowserType();
		MyDriver driver = null;
		switch (browserType) {
		case "IE":
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\browserdriver\\IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			driver = new MyDriver(new InternetExplorerDriver(ieCapabilities));
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", EnvironmentVariable.getChromeLocation());
			ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
							new File(System.getProperty("user.dir") + "\\browserdriver\\chromedriver.exe")).usingAnyFreePort().build();
			try {
				service.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver = new MyDriver(new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome()));
			break;
		case "Firefox":
			File profileDir = new File(System.getProperty("user.dir") + "\\firefoxprofile");
			if (profileDir.exists()) {
				System.out.println("Now will launch FF with designated profile.");
				FirefoxProfile firefoxprofile = new FirefoxProfile(profileDir);
				driver = new MyDriver(new FirefoxDriver(firefoxprofile));
				return driver;
			}
			System.out.println("Unable to launch FF with designated profile, now will launch default profile.");
			driver = new MyDriver(new FirefoxDriver());
			break;
		default:
			profileDir = new File(System.getProperty("user.dir") + "\\firefoxprofile");
			if (profileDir.exists()) {
				System.out
						.println("Now will launch FF with designated profile.");
				FirefoxProfile firefoxprofile = new FirefoxProfile(profileDir);
				driver = new MyDriver(new FirefoxDriver(firefoxprofile));
				return driver;
			}
			System.out.println("Unable to launch FF with designated profile, now will launch default profile.");
			driver = new MyDriver(new FirefoxDriver());
			break;
		}
//		File profileDir = new File(System.getProperty("user.dir") + "\\firefoxprofile");
//		if (profileDir.exists()) {
//			System.out.println("Now will launch FF with designated profile.");
//			FirefoxProfile firefoxprofile = new FirefoxProfile(profileDir);
//			driver = new MyDriver(new FirefoxDriver(firefoxprofile));
//			return driver;
//		}
//		System.out.println("Unable to launch FF with designated profile, now will launch default profile.");
//		driver = new MyDriver(new FirefoxDriver());
		return driver;
	}

}
