package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pageObject.PageObject;
import utility.file.ExcelUtil;
import baseline.AutoContext;
import baseline.MyDriver;

public class LoginPage implements PageObject {

	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	private String userName = "//input[@id='username']";
	private String passWord = "//input[@id='password']";
	private String loginButton = "//input[@id='button_login']";
	private String pageTitle = "//li[@id='see']//span";
	

	public void getCurrentPage() {
		driver.get(ExcelUtil.getData("BMW"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void inputUserName(String str) {
		WebElement username = driver.findMyWebElement(By.xpath(userName));
		username.sendKeys(str);
	}
	
	public void inputPassword(String str){
		WebElement psw = driver.findMyWebElement(By.xpath(passWord));
		psw.sendKeys(str);
	}
	
	public void clickLoginBtn(){
		WebElement btn = driver.findMyWebElement(By.xpath(loginButton));
		btn.click();
	}
	
	public String getPageTitle(){
		String str = driver.findMyWebElement(By.xpath(pageTitle)).getText();
		logger.info(str);
		return str;
	}

}
