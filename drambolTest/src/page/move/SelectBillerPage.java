package page.Move;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.MyElement;
import pageObject.PageLoader;
import pageObject.PageObject;

public class SelectBillerPage implements PageObject{
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(SelectBillerPage.class);
	private String selectBillerType = "//li[@id='Type']/descendant::a[text()='Please select Biller Type']";
	private String selectBillerName = "//li[@id='BillerName']/descendant::a[text()='Please select Biller Name']";
	private String accuontNumber = "//input[@id='AccountNumber']";
	private String accuontPIN = "//input[@id='AccountPIN']";
	private String continueButton = "//input[@type='submit']";
	
	public BillerTypeListPage SelectBillerType(){
		MyElement ele = driver.findMyWebElement(By.xpath(selectBillerType));
		ele.click();
		return PageLoader.load(BillerTypeListPage.class);	
	}
	
	public BillerNameListPage SelectBillerName(){
		MyElement ele = driver.findMyWebElement(By.xpath(selectBillerName));
		ele.click();	
		return PageLoader.load(BillerNameListPage.class);	
	}
	
	public void AccountNumber(String str){
		MyElement ele = driver.findMyWebElement(By.xpath(accuontNumber));
		ele.sendKeys(str);
	}
	
	public void AccountPIN(String str){
		MyElement ele = driver.findMyWebElement(By.xpath(accuontPIN));
		ele.sendKeys(str);
	}
	
	public AddBillerConfirmPage ClickContinue(){
		MyElement ele = driver.findMyWebElement(By.xpath(continueButton));
		ele.click();
		return PageLoader.load(AddBillerConfirmPage.class);
	}
}
