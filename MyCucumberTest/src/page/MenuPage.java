package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.PageObject;

public class MenuPage implements PageObject {

	public MyDriver myDriver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(MenuPage.class);
	private String un = "username_input";
	
	public void inputUsername(String userName){
		WebElement username = myDriver.findMyWebElement(By.id(un));
		username.sendKeys(userName);
	}

}
