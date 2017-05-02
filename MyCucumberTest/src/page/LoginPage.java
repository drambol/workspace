package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.PageObject;
import utility.file.ExcelUtil;

public class LoginPage implements PageObject {

	public MyDriver myDriver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	private String name = "username_input";
	private String psw = "password_input";
	private String btn = "login_button";

	public void getCurrentPage() throws InterruptedException {
		myDriver.get(ExcelUtil.getData(8, 2));
		myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void inputUsername(String userName){
		WebElement username = myDriver.findMyWebElement(By.id(name));
		username.sendKeys(userName);
	}
	
	public void inputPassword(String passWord){
		WebElement password = myDriver.findMyWebElement(By.id(psw));
		password.sendKeys(passWord);
	}
	
	public void clickLoginBtn(){
		WebElement login = myDriver.findMyWebElement(By.id(btn));
		login.click();
	}
	
	public void verifyLoginSuccessfully(){
//		Assert.assertEquals(myDriver.findWebElement(By.xpath("//li[@id='see']/a/span")).getText(), "See");
		Assert.assertEquals(myDriver.findMyWebElement(By.xpath("//a[@id='menu']/span")).getText(), "Menu");
	}

}
