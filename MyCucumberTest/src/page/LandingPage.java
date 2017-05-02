package page;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.PageLoader;
import pageObject.PageObject;

public class LandingPage implements PageObject {

	public MyDriver myDriver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(LandingPage.class);
	private String menu = "//a[@id='menu']/span";
	
	public MenuPage clickMenu(){
		myDriver.findMyWebElement(By.xpath(menu));		
		myDriver.perform(By.xpath(menu));
		return PageLoader.load(MenuPage.class);
	}
}
