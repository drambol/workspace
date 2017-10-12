package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;

public class BaiduResult {
	
	@Given("^User click link")
	public void user_click_desinated() throws Throwable {
		WebElement link = StartUp.driver.findElement(By.xpath("//a[@class='res-gap-right16']/strong"));
		link.click();  
	}


}
