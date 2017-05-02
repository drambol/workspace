package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface MyWebElement extends WebElement{
	
public abstract MyElement findMyWebElement(By by);
	
public abstract List<MyElement> findMyWebElements(By by);
	

}
