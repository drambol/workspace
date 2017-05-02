package business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import page.LoginPage;
import pageObject.PageLoader;
import utility.calc.MyAssert;
import utility.file.ExcelUtil;

public class AELoginBusiness {

	static final Logger logger = LoggerFactory.getLogger(AELoginBusiness.class);
	LoginPage loginPage = PageLoader.load(LoginPage.class);
	private String username = ExcelUtil.getData("UserName");
	private String password = ExcelUtil.getData("PassWord");

	public void AELogin() {
		loginPage.getCurrentPage();
		loginPage.inputUserName(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginBtn();
	}

	public void verifyLoginSuccess() {
		MyAssert.assertEqual(loginPage.getPageTitle(), "See");
	}

}
