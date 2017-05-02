package page.Move;

import java.util.List;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.MyElement;
import pageObject.PageLoader;
import pageObject.PageObject;

public class BillerTypeListPage implements PageObject{
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(BillerTypeListPage.class);
	private MyElement billerType;
	
	public List<MyElement> getBillerTypeList(){
		List<MyElement> billerTypeList = driver.findMyWebElements(By.xpath("//div[@class='list-view']/ul/li"));
		return billerTypeList;
	}
	
	public SelectBillerPage selectBillerType(String str){
		String xpath = "//div[@class='list-view']/ul/descendant::li[text()='"+ str +"']";
		billerType = driver.findMyWebElement(By.xpath(xpath));
		billerType.click();
		return PageLoader.load(SelectBillerPage.class);
	}
}
