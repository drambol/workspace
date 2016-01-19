package testCase;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import baseline.MyDriver;

public class IndependantTest {
	
	@Test
	public void test1() {
		MyDriver driver = null;
		File profileDir = new File(System.getProperty("user.dir") + "\\firefoxprofile");
		FirefoxProfile firefoxprofile = new FirefoxProfile(profileDir);
		driver = new MyDriver(new FirefoxDriver(firefoxprofile));
		driver.get("http://www.google.com.hk/");
//		String str = driver.findMyWebElements("//table[@id='gs_id0']//input").get(1).getCssValue("color");
//		driver.findMyWebElements("//table[@id='gs_id0']//input").get(0).input("selenium");
		driver.findMyWebElement("//input[@id='lst-ib']").input("selenium");
		
//		System.out.println("Output: " + str);
	}

}
