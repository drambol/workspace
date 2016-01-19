package baseline;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObject.MyWebElement;

//This interface now is useless.
public interface MyWebDriver extends WebDriver {
	
	public abstract MyWebElement findMyWebElement(By by);
	
	public abstract boolean hasText(String str);
	
	@SuppressWarnings("rawtypes")
	public abstract List findMyWebElements(By by);
	
}