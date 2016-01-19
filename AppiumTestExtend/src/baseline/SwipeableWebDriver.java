package baseline;

import io.appium.java_client.AppiumDriver;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.RemoteTouchScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwipeableWebDriver extends AppiumDriver {
	
	static final Logger logger = LoggerFactory.getLogger(SwipeableWebDriver.class);
	private RemoteTouchScreen touch;
	public WebDriver driver;
	public static final int elementLocatorTimeOut = 20;
	
	public SwipeableWebDriver(URL remoteAddress, Capabilities desiredCapabilities) {
		super(remoteAddress, desiredCapabilities);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		touch = new RemoteTouchScreen(getExecuteMethod());
	}

	public TouchScreen getTouch() {
		return touch;
	}
	
	@Override
	public WebElement findElement(By by) {
		for (int i = 0; i < elementLocatorTimeOut; i++) {
			try {
				return by.findElement(this);
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
					logger.info("Waiting for element to display... " + i + " (" + by.toString() + ")");
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		logger.info("Time out waiting for element: " + by.toString());
        return null;
    }
	
	@Override
	public List<WebElement> findElements(By by) {
		for (int i = 0; i < elementLocatorTimeOut; i++) {
			try {
				return by.findElements(this);
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		logger.info("Time out waiting for element: " + by.toString());
        return null;
    }
	
	public WebElement findElement(By by, int second) {
		for (int i = 0; i < second; i++) {
			try {
				WebElement webElement =  by.findElement(this);
				logger.info("Element locate time: " + i + " seconds (" + by.toString() + ")");
				return webElement;
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		logger.info("Time out waiting for element: " + by.toString());
        return null;
    }
}