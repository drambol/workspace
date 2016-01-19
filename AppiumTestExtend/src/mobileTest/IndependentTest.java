package mobileTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import utility.file.EnvironmentVariable;
import utility.file.XmlParser;
import utility.system.WindowsProcess;

import baseline.SwipeableWebDriver;

public class IndependentTest {
	
//	public static void main(String args[]){
//		System.out.println("Sasa is a good boy!");
//	}
	
	@Test
	public void test() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		XmlParser xmlParser = new XmlParser("runSuite\\MobileConfig.xml");
		capabilities.setCapability("app", EnvironmentVariable.getApkLocation());
		capabilities.setCapability("platformName", xmlParser.getNodeValue("platformName"));
		capabilities.setCapability("deviceName", xmlParser.getNodeValue("deviceName"));
		capabilities.setCapability("app-package", xmlParser.getNodeValue("app-package"));
		capabilities.setCapability("app-activity", xmlParser.getNodeValue("app-activity"));
		System.out.println("Prepare to get the driver!");
		new SwipeableWebDriver(new URL("http://localhost:8086/wd/hub"), capabilities);
		System.out.println("Sasa is a good boy!");
	}
	
	@Test
	public void test1() {
//		WindowsProcess.killProcess("conhost.exe");
		WindowsProcess.killProcess("emulator-arm.exe");
	}

}