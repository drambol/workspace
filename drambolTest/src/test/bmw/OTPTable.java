package test.bmw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import baseline.AutoContext;
import baseline.MyDriver;
import baseline.WebDriverCreator;
import utility.file.ExcelUtil;
import utility.tableUtility.MyTable;

public class OTPTable {

	private static MyDriver newDriver;

	private static void setUpBrowser() {
		newDriver = WebDriverCreator.create();
		newDriver.manage().window().maximize();
		newDriver.get(ExcelUtil.getData("Get2FAMessages"));
		AutoContext.otpTL.set(newDriver);
	}

	public static String retrieveOTP() {
		
		//open new tab
//		JavascriptExecutor jse = (JavascriptExecutor) (newDriver);
//		// open new tab for getting OTP
//		String url = url;
//		jse.executeScript("window.open(arguments[0])", url);
//
//		// get all the opened tabs and switch to OTP tab
//		ArrayList<String> tabs = new ArrayList<String>(newDriver.getWindowHandles());
//		newDriver.switchTo().window(tabs.get(1));
		
		//open new chrome
		OTPTable.setUpBrowser();
		Select environment = new Select(newDriver.findMyWebElement(By.xpath("//select[@name='env']")));
		Select country = new Select(newDriver.findMyWebElement(By.xpath("//select[@name='country']")));
		WebElement user = newDriver.findMyWebElement(By.xpath("//input[@name='userId']"));
		WebElement go = newDriver.findMyWebElement(By.xpath("//input[@id='go']"));
		environment.selectByVisibleText(ExcelUtil.getData(1, 2));
		country.selectByVisibleText(ExcelUtil.getData(2, 2));
		user.sendKeys(ExcelUtil.getData(4, 2));
		go.click();
		MyTable table = new MyTable(By.xpath("//table[2]"), newDriver);
		String str = table.cells(2, 3).getText();
		System.out.println(str);
//		str = str.split("\\(OTP\\) is ")[1].split(" ")[0];
//		System.out.println(str);
		
		String regex = "([0-9]{6})\\s";

		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str);
		String OTPValue = "";
		while (match.find()) {
			OTPValue = match.group(0).trim();
		}
		
		System.out.println(OTPValue);	
		OTPTable.closeDownBrowser();
		return OTPValue;
	}

	private static void closeDownBrowser() {
		AutoContext.otpTL.set(null);
		newDriver.quit();
	}

}
