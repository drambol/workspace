package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.MyWebElement;

public class TermConditions extends BaseCaseTemplate {
	@Test
	public void loginTest() throws InterruptedException {

		MyDriver driver = AutoContext.myWebDriverTL.get();

		driver.get("https://10.112.179.177:10004/register/index.html?lang=hans&ctry=CN");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//div[@class='TNC-button']")));
		driver.findMyWebElement(By.xpath("//div[@class='TNC-button']"));
		System.out.println("I am going to click the T&C button");
		// driver.perform(By.xpath("//div[@class='TNC-button']"));
		WebElement TC = driver.findElement(By.xpath("//div[@class='TNC-button']"));
		Thread.sleep(5000);
		Actions actions = new Actions(driver.getOriginalDriver());
		actions.moveToElement(TC).click().perform();
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		MyWebElement ele = driver.findMyWebElement(By.xpath("//button[@id='TNCokBtn']"));
		ele.click();

		System.out.println("Login Successfully");
	}
}
