package stepDefinition;

import cucumber.api.java.en.When;
import page.LandingPage;
import pageObject.PageLoader;

public class MenuSteps {

	private LandingPage landingPage = PageLoader.load(LandingPage.class);

	@When("User clicks Menu$")
	public void click_menu() throws Throwable {
		landingPage.clickMenu();
	}

}
