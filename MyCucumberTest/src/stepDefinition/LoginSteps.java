package stepDefinition;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.LoginPage;
import pageObject.PageLoader;

public class LoginSteps {

	private LoginPage loginPage = PageLoader.load(LoginPage.class);

	@When("^User enters \"(.*)\" and \"(.*)\" and click Login$")
	public void login_with_username(String userName, String passWord) throws Throwable {
//		loginPage.getDriver();
		loginPage.inputUsername(userName);
		loginPage.inputPassword(passWord);
		loginPage.clickLoginBtn();
		System.out.println("I am login with" + userName);
	}
	
	@When("^User enters username and password and click Login$")
	public void login_with_username(DataTable usercredentials) throws Throwable {
		List<List<String>> data = usercredentials.raw();
		loginPage.inputUsername(data.get(0).get(0));
		loginPage.inputPassword(data.get(0).get(1));
		loginPage.clickLoginBtn();
		System.out.println("I am login with" + data.get(0).get(0));
	}

	@Then("^User Login Successfully$")
	public void login_successfully() throws Throwable {
		loginPage.verifyLoginSuccessfully();
		System.out.println("User LoginSuccessfully");
	}

}