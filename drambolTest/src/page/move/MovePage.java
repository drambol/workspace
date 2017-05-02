package page.Move;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.MyElement;
import pageObject.PageLoader;
import pageObject.PageObject;

public class MovePage implements PageObject {

	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(MovePage.class);
	private String history = "//a[@id='complementary-info']/span";
	private String move = "//li[@id='move']/a";
	private String selectToAccount = "//li[@id='Move-To']/descendant::a[text()='Select an account']";

	public void getCurrentPage() {
		driver.findMyWebElement(By.xpath(move));
		driver.perform(By.xpath(move));
	}
	
	public PaymentHistoryPage viewHistory(){
		MyElement ele = driver.findMyWebElement(By.xpath(history));
		ele.click();	
		return PageLoader.load(PaymentHistoryPage.class);	
	}
	
	public ToPage SelectToAccount(){	
		driver.findMyWebElement(By.xpath(selectToAccount));
		driver.perform(By.xpath(selectToAccount));
		return PageLoader.load(ToPage.class);	
	}

}
