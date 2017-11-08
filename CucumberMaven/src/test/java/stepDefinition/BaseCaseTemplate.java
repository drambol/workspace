package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by 1547857 on 11/8/2017.
 */
public class BaseCaseTemplate {
    public static WebDriver driver;

    @Before
    public void startUp(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver","C:\\Grace\\Useful Matierials\\mine\\Selenium Webdriver\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }

    @After
    public void shutdown(){
        driver.quit();
    }
}
