package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utility.dateTime.DateTime;
import utility.file.StringUtil;

public class MyElement implements MyWebElement {

	static final Logger logger = LoggerFactory.getLogger(MyElement.class);

	private WebElement element;
	private WebDriver driver;

	public MyElement(WebDriver driver) {
		this.driver = driver;
	}

	public MyElement(WebElement element) {
		this.element = element;
	}

	public boolean exists() {
		try {
			return element.isDisplayed();
		} catch (IndexOutOfBoundsException e) {
		}
		return false;
	}

	public void clear() {
		element.clear();
	}

	public void click() {
		DateTime.sleep(500);
		element.click();
		DateTime.sleep(500);
	}

	public WebElement findElement(By by) {
		return element.findElement(by);
	}

	public List<WebElement> findElements(By by) {
		return element.findElements(by);
	}

	public String getAttribute(String s) {
		return element.getAttribute(s);
	}

	public String getCssValue(String s) {
		return element.getCssValue(s);
	}

	public Point getLocation() {
		return element.getLocation();
	}

	public Dimension getSize() {
		return element.getSize();
	}

	public String getTagName() {
		return element.getTagName();
	}

	public String getText() {
		return element.getText();
	}

	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	public boolean isEnabled() {
		return element.isEnabled();
	}

	public boolean isSelected() {
		return element.isSelected();
	}

	public void sendKeys(CharSequence... acharsequence) {
		DateTime.sleep(500);
		element.sendKeys(acharsequence);
	}

	public void input(String str) {
		DateTime.sleep(500);
		logger.info("Input value: " + str);
		element.clear();
		element.sendKeys(str);
	}

	public void submit() {
		element.submit();
	}

	public MyElement findMyWebElement(By by) {
		try {
			changeBackgroundColor(by);
			WebElement el = element.findElement(by);
			return new MyElement(el);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public MyElement findMyWebElement(String xpath) {
		try {
			changeBackgroundColor(xpath);
			WebElement el = element.findElement(By.xpath(xpath));
			return new MyElement(el);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public List<MyElement> findMyWebElements(By by) {
		try {
			List<WebElement> elements = element.findElements(by);
			List<MyElement> list = new ArrayList<MyElement>();
			for (WebElement e : elements) {
				list.add(new MyElement(e));
			}
			return list;
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public List<MyElement> findMyWebElements(String xpath) {
		try {
			List<WebElement> elements = element.findElements(By.xpath(xpath));
			List<MyElement> list = new ArrayList<MyElement>();
			for (WebElement e : elements) {
				list.add(new MyElement(e));
			}
			return list;
		} catch (NoSuchElementException e) {
			logger.info("Failed to find such element: " + xpath);
			return null;
		}
	}

	private void changeBackgroundColor(By by) {
		String xpathId = StringUtil.getXpathId(by);
		String xpathName = StringUtil.getXpathName(by);
		String javascript = "";
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			if (xpathId != "") {
				javascript = "document.getElementById(\"" + xpathId + "\").style.background=\"yellow\"";
				executor.executeScript(javascript);
			}
			if (xpathName != "") {
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
			if (xpathId != "") {
				javascript = "document.getElementById(\"" + xpathId + "\").style.background=\"yellow\"";
				executor.executeScript(javascript);
			}
			if (xpathName != "") {
				javascript = "document.getElementByName(\"" + xpathName + "\").style.background=\"yellow\"";
				executor.executeScript(javascript);
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		executor = null;
	}

	public void select(String str) {
		List<WebElement> options = element.findElements(By.tagName("option"));
		int i = 0;
		for (i = 0; i < options.size(); i++) {
			WebElement option = options.get(i);
			String text = option.getText();
			String value = option.getAttribute("value");
			if (str.equals(text) || str.equals(value)) {
				logger.info("Select value: " + str);
				option.click();
				break;
			}
		}
		if (i == options.size()) {
			throw new RuntimeException("Can not find option: " + str + " in select element!");
		}
	}

	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	public <X> X getScreenshotAs(OutputType<X> outputtype) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

}
