package test.selfTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenerTest extends EventListenerExample{
	
	@Test
	public void testEventsONE() {
		System.out.println("***** Executing Test ONE ***** ");
		EventListenerExample.e_driver.get("http://www.baidu.com/");
		WebElement txtbox = EventListenerExample.e_driver.findElement(By.name("w"));//EventListener will capture this exception
		txtbox.sendKeys("StandardChartered");
		WebElement btn = EventListenerExample.e_driver.findElement(By.id("su"));
		btn.click();

		Assert.assertEquals(EventListenerExample.e_driver.findElement(By.xpath("//div[@id='1']/h3/a/em")).getText(), "Standard Chartered",
				"test pass");
	}

}
