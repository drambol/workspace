package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageObject.MyElement;
import utility.file.StringUtil;

public class MyDriver implements JavascriptExecutor {
	
	public WebDriver driver;
	static final Logger logger = LoggerFactory.getLogger(MyDriver.class);
	
	public MyDriver(WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver getOriginalDriver() {
		return driver;
	}
	
	public void close() {
		driver.close();
	}
	
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}
	
	public List<WebElement> findElements(By by) {
		return driver.findElements(by);
	}
	
	public void get(String s) {
		driver.get(s);
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource() {
		return driver.getPageSource();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}
	
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public Navigation navigate() {
		return driver.navigate();
	}
	
	public void quit() {
		driver.quit();
	}
	
	public TargetLocator switchTo() {
		return driver.switchTo();
	}
	
	public MyElement findMyWebElement(By by) {
		try {
			changeBackgroundColor(by);
			WebElement element =  driver.findElement(by);
			return new MyElement(element);
		} catch (NoSuchElementException e1) {
			return null;
		} catch (NullPointerException e2) {
			return null;
		}
	}
	
	public MyElement findMyWebElement(String xpath) {
		try {
			changeBackgroundColor(xpath);
			WebElement element =  driver.findElement(By.xpath(xpath));
			return new MyElement(element);
		} catch (NoSuchElementException e1) {
			return null;
		} catch (NullPointerException e2) {
			return null;
		}
	}
	
	public List<MyElement> findMyWebElements(By by) {
		try {
			List<WebElement> elements = driver.findElements(by);
			List<MyElement> list = new ArrayList<MyElement>();
			for(WebElement e : elements){
				list.add(new MyElement(e));
			}
			return list;
		} catch (NoSuchElementException e1) {
			return null;
		} catch (NullPointerException e2) {
			return null;
		}
	}
	
	public List<MyElement> findMyWebElements(String xpath) {
		try {
			List<WebElement> elements = driver.findElements(By.xpath(xpath));
			List<MyElement> list = new ArrayList<MyElement>();
			for(WebElement e : elements){
				list.add(new MyElement(e));
			}
			return list;
		} catch (NoSuchElementException e1) {
			return null;
		} catch (NullPointerException e2) {
			return null;
		}
	}
	
	public boolean judgeElementExistance(MyElement element) {
		try {
			element.click();
		} catch(NoSuchElementException e1) {
			return false;
		} catch(ElementNotVisibleException e2) {
			return false;
		}
		return true;
	}
	
	public boolean hasText(String str) {
		boolean flag = driver.getPageSource().contains(str);
		if (flag) {
			logger.info("Find texts: " + str);
		} else {
			logger.info("Failed to find texts: " + str);
		}
		return flag;
	}
	
	private void changeBackgroundColor(By by) {
		String xpathId = StringUtil.getXpathId(by);
		String xpathName = StringUtil.getXpathName(by);
		String javascript = "";
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			if(xpathId!="") {
				javascript = "document.getElementById(\"" + xpathId + "\").style.background=\"yellow\"";
				executor.executeScript(javascript);
			}
			if(xpathName!="") {
				javascript = "document.getElementByName(\"" + xpathName + "\").style.background=\"yellow\"";
				executor.executeScript(javascript);
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		executor = null;
	}
	
	private void changeBackgroundColor(String str) {
		String xpathId = StringUtil.getXpathId(str);
		String xpathName = StringUtil.getXpathName(str);
		String javascript = "";
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			if(xpathId!="") {
				javascript = "document.getElementById(\"" + xpathId + "\").style.background=\"yellow\"";
				executor.executeScript(javascript);
			}
			if(xpathName!="") {
				javascript = "document.getElementByName(\"" + xpathName + "\").style.background=\"yellow\"";
				executor.executeScript(javascript);
			}
		} catch (WebDriverException e) {
		}
		executor = null;
	}
	
	@Override
	public Object executeScript(String script, Object... args) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript(script, args);
	}

	@Override
	public Object executeAsyncScript(String script, Object... args) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeAsyncScript(script, args);
	}
	
}