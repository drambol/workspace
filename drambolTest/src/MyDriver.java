package baseline;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageObject.MyElement;
import utility.file.StringUtil;

public class MyDriver implements WebDriver, JavascriptExecutor{
	
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
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				WebElement element =  driver.findElement(by);
				changeBackgroundColor(by);
				if (i > 0)
					System.out.println("Element found: " + by.toString());
				return new MyElement(element);
			} catch (NoSuchElementException e1) {
				System.out.println("NoSuchElementException: " + by.toString());
			} catch (NullPointerException e2) {
				e2.printStackTrace();
			} catch (InterruptedException e3) {
				e3.printStackTrace();
			}
		}
		return null;
	}
	
	public MyElement findMyWebElement(String xpath) {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
				WebElement element =  driver.findElement(By.xpath(xpath));
				changeBackgroundColor(xpath);
				if (i > 0)
					System.out.println("Element found: " + xpath);
				return new MyElement(element);
			} catch (NoSuchElementException e1) {
				System.out.println("NoSuchElementException: " + xpath);
			} catch (NullPointerException e2) {
				e2.printStackTrace();
			} catch (InterruptedException e3) {
				e3.printStackTrace();
			}
		}
		return null;
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
	
	public String getDelayedText(By by) {
		String str = "";
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				str = driver.findElement(by).getText();
				if (str.length() > 0)
					break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	
	public void perform(By by) {
		WebElement element = driver.findElement(by);
		try {
			Thread.sleep(5000);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void perform(MyElement ele) {
		try {
			Thread.sleep(5000);
			Actions actions = new Actions(driver);
			actions.moveToElement(ele).click().perform();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public Options manage() {
		// TODO Auto-generated method stub
		return driver.manage();
	}
	
}