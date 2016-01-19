package page.miscellaneous;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.PageObject;
import utility.dateTime.DateTime;

public class BrokerHelperPage implements PageObject{
	
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(BrokerHelperPage.class);
	
	public void getCurrentPage() {
		driver.get("http://10.41.100.50:98/BrokerHelpers.asmx");
		DateTime.sleep(3000);
	}
	
	public String getEventsGeneric() {
		driver.findMyWebElement("//a[text()='getEventsGeneric']").click();
		driver.findMyWebElement("//input[@name='webSite']").input("spx");
		driver.findMyWebElement("//input[@name='locale']").input("en");
		driver.findMyWebElement("//input[@value='Invoke']").click();
		DateTime.sleep(3000);
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		String str = driver.getPageSource();
		driver.close();
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		return str;
	}

}
