package baseline;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utility.file.EnvironmentVariable;

/**
 * 
 * @author Wenjuan.Zhou
 * @Purpose Create web driver by browser type
 */
public class WebDriverCreator {
	
//	public static synchronized WebDriver create(){
//		WebDriver WebDriver = null;
//		
//		 System.setProperty(
//		 "webdriver.chrome.driver",
//		 EnvironmentVariable.getChromeLocation());
//		 WebDriver = new ChromeDriver();
//		 return WebDriver;
//	}

//	public static synchronized MyDriver create() {
//
//		MyDriver driver = null;
//		ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(EnvironmentVariable.getChromeLocation())).usingAnyFreePort().build();
//		try {
//			service.start();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver = new MyDriver(new RemoteWebDriver(service.getUrl(),
//				DesiredCapabilities.chrome()));
//
//		return driver;
//
//	}
	
	public static synchronized MyDriver create() {

		 MyDriver driver = null;
		
		 System.setProperty("webdriver.chrome.driver",EnvironmentVariable.getChromeLocation());
		 driver = new MyDriver(new ChromeDriver());
		 return driver;

	}

}
