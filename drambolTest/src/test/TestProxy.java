package test;

import java.util.Arrays;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class TestProxy {
	
	@Test
	public void firefox() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.http", "10.24.129.241");
		profile.setPreference("network.proxy.http_port", 8080);
		WebDriver driver = new FirefoxDriver(profile);
		driver.get("https://10.112.176.199:9443/nfs-tools/test/Get2FAMessages.jsp");
	}
	
	@Test
	public void chrome() {
		String proxyIpAndPort= "http://10.23.20.143:8080";
		Proxy proxy=new Proxy();
		proxy.setHttpProxy(proxyIpAndPort);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ForSeleniumServer.AVOIDING_PROXY, true);
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ONLY_PROXYING_SELENIUM_TRAFFIC, true);
		capabilities.setCapability(CapabilityType.PROXY, proxy);
		capabilities.setCapability("chrome.switches", "--proxy-server=http://10.23.20.143:8080");
		WebDriver driver = new ChromeDriver(capabilities);
		driver.get("http://www.baidu.com/");
	}

}
