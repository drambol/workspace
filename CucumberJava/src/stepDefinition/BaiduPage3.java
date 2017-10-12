package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;

public class BaiduPage3 {
		
	@Given("^User click url")
	public void user_click_desinated() throws Throwable {
		WebElement link = StartUp.driver.findElement(By.xpath("//a[text()='aram']"));
		link.click();  
	}

}
