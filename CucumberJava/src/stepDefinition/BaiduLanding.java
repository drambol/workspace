package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class BaiduLanding {
	
	@Given("^User go to \"([^\"]*)\"$")
	public void user_is_on_Home_Page(String site) throws Throwable {
		StartUp.driver.get(site);    
	}

	@When("^User enters \"(.*)\"$")
	public void user_enters_keywords_and_click_search(String keyword) {
		WebElement txtbox = StartUp.driver.findElement(By.name("wd"));
		txtbox.sendKeys(keyword);
		System.out.println("I am searching with" + keyword);
	}

	@When("^User click search$")
	public void user_click_search() {
		WebElement btn = StartUp.driver.findElement(By.id("su"));
		btn.click();
	}

}
