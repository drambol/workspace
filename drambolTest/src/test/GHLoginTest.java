package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.MyElement;
import utility.file.ExcelUtil;

public class GHLoginTest extends BaseCaseTemplate {

	@Test
	public void loginTest() {

		MyDriver driver = AutoContext.myWebDriverTL.get();

		driver.get(ExcelUtil.getData("BMW"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement username = driver.findMyWebElement(By.xpath("//input[@id='username_input']"));
		username.sendKeys(ExcelUtil.getData("UserName"));
		WebElement psw = driver.findMyWebElement(By.xpath("//input[@id='password_input']"));
		psw.sendKeys(ExcelUtil.getData("PassWord"));
		WebElement btn = driver.findMyWebElement(By.xpath("//input[@type='submit']"));
		btn.click();
		System.out.println("test");
		driver.findMyWebElement(By.xpath("//div[@class='ember-view']/descendant::tr[@class='clickable with-icon']")).click();

	}
}
