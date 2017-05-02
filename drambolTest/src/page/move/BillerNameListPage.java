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

public class BillerNameListPage implements PageObject{
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(BillerNameListPage.class);
	private MyElement billerName;
	
	public List<MyElement> getBillerNameList(){
		List<MyElement> billerNameList = driver.findMyWebElements(By.xpath("//div[@class='list-view']/ul/li"));
		return billerNameList;
	}
	
	public SelectBillerPage selectBillerName(String str){
		String xpath = "//div[@class='list-view']/ul/descendant::li[text()='"+ str +"']";
		billerName = driver.findMyWebElement(By.xpath(xpath));
		billerName.click();
		return PageLoader.load(SelectBillerPage.class);
	}
}
