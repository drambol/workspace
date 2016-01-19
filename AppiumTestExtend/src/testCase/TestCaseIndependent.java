package testCase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import baseline.MyDriver;
import static org.junit.Assert.*;

import utility.calc.Algorithm;
import utility.file.FileUtility;
import utility.file.XmlParser;
import utility.javamail.MailSenderInfo;
import utility.javamail.SimpleMailSender;

public class TestCaseIndependent {
	
	static final Logger logger = LoggerFactory.getLogger(TestCaseIndependent.class);

	@Test
	public void mailTest() {
		MailSenderInfo mailInfo = new MailSenderInfo();
		String[] args = new String[10];
		args[0] = "C:\\TestData\\NOTICE.txt";

		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(false);
		mailInfo.setUserName("ken_pwc@163.com");
		mailInfo.setPassword("p@ssw0rd");
		mailInfo.setFromAddress("ken_pwc@163.com");
		mailInfo.setToAddress("kencsdn1@163.com");
		mailInfo.setSubject("mailTest");
		mailInfo.setContent("Greeting from java mail servlet.");
		mailInfo.setAttachFileNames(args);
		mailInfo.getAttachFileNames();
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendTextMail(mailInfo);
		sms.sendHtmlMail(mailInfo);
	}

	@Test
	public void testJavaScriptCalls() {
		MyDriver driver = new MyDriver(new FirefoxDriver());
		driver.get("http://www.google.com.hk");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = (String) js.executeScript("return document.title");
		assertEquals("Google", title);
		long links = (Long) js.executeScript("var links = "
				+ "document.getElementsByTagName('A'); "
				+ "return links.length");
		assertEquals(32, links);
		driver.close();
	}
	
	@Test
	public void sort() {
		int count = 30;
		double[] arg1 = new double[count];
		double num;
		for (int i = 0; i < count; i++) {
			num = Algorithm.getRandomDouble(0, 100);
			arg1[i] = num;
		}
		double[] arg2 = Algorithm.sort(arg1, false);
		for (int i = 0; i < count; i++) {
			System.out.println(arg2[i]);
		}
	}
	
	@Test
	public void sadf() {
		String url = "http://localhost/getEventsGeneric.xml";
		String fileName = "test.xml";
		FileUtility.generateFile(fileName, url);
		XmlParser xml = new XmlParser(fileName);
		String str = xml.getNodeValue("Title");
		System.out.println(str);
	}
	
	public static void main(String[] args) {
	}

}
