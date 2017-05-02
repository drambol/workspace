package baseline;

import org.openqa.selenium.WebDriver;
/**
 * @author Wenjuan.Zhou
 * @Purpose Initiate a web driver thread
 */
public class AutoContext {
	public static final ThreadLocal<WebDriver> webDriverTL = new ThreadLocal<WebDriver>();
	public static final ThreadLocal<MyDriver> myWebDriverTL = new ThreadLocal<MyDriver>();
	public static final ThreadLocal<MyDriver> otpTL = new ThreadLocal<MyDriver>();
}
