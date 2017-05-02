package baseline;

import org.openqa.selenium.chrome.ChromeDriver;

import utility.file.EnvironmentVariable;

/**
 * 
 * @author Wenjuan.Zhou
 * @Purpose Create web driver by browser type
 */
public class WebDriverCreator {

	public static synchronized MyDriver create() {

		 MyDriver driver = null;
		
		 System.setProperty("webdriver.chrome.driver",EnvironmentVariable.getChromeLocation());
		 driver = new MyDriver(new ChromeDriver());
		 return driver;

	}

}
