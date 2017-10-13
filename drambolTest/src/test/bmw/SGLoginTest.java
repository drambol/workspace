package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.file.ExcelUtil;
import baseline.AutoContext;
import baseline.MyDriver;

public class SGLoginTest extends BaseCaseTemplate {

	@Test
	public void loginTest() {

		MyDriver driver = AutoContext.myWebDriverTL.get();
		
		driver.get(ExcelUtil.getData("SG"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement username = driver.findMyWebElement(By
				.xpath("//input[@id='username_input']"));
		username.sendKeys("BMWTEST002");
		WebElement psw = driver
				.findMyWebElement(By.xpath("//input[@id='password_input']"));
		psw.sendKeys("ibnk1357");
		WebElement btn = driver.findMyWebElement(By
				.xpath("//input[@type='submit']"));
		btn.click();

		String str = driver.getDelayedText(By.xpath("//h2[@id='nav-title']"));
		System.out.println("test: " + str);
		Assert.assertEquals(str, "See", "Test Pass");
		System.out.println("Login Successfully");

	}
}
