package page.Move;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.MyElement;
import pageObject.PageLoader;
import pageObject.PageObject;

public class ToPage implements PageObject{
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(ToPage.class);
	private String addBiller = "//div[@class='list-view']/descendant::a[text()='Add Biller']";
	
	public SelectBillerPage SelectTxnType(){
		MyElement ele = driver.findMyWebElement(By.xpath(addBiller));
		ele.click();	
		return PageLoader.load(SelectBillerPage.class);	
	}
}
