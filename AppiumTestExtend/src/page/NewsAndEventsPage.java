package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.MyElement;
import pageObject.PageLoader;
import pageObject.PageObject;
import utility.database.ExcelUtil;
import utility.dateTime.DateTime;
import utility.file.EnvironmentVariable;

public class NewsAndEventsPage implements PageObject {
	
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(NewsAndEventsPage.class);
	protected String testSheet = "NewsAndEventsPage";
	
	public void getCurrentPage() {
		String url = driver.getCurrentUrl();
		if (!url.substring(url.length() - 8, url.length() - 1).equalsIgnoreCase("-events")) {
			driver.get(EnvironmentVariable.getUrl("NewsAndEventsPage"));
			DateTime.sleep(1000);
		}
	}
	
	public NewsAndEventsPage navigateTo(String str) {
		driver.findMyWebElement(By.xpath("//a[text()='" + str + "']")).click();
		DateTime.sleep(5000);
		return PageLoader.load(NewsAndEventsPage.class);
	}
	
	public void getAllEvents() {
		this.clearData();
		driver.findMyWebElement("//li[text()='All']").click();
		DateTime.sleep(5000);
		List<MyElement> events = driver.findMyWebElements(ExcelUtil.getData(testSheet, 1, 6));
		int rowNum = 1;
		for(int i = 0; i < events.size(); i++) {
			logger.info("Get Event: " + getEventName(events.get(i)));
			ExcelUtil.writeData(testSheet, rowNum, 0, getEventName(events.get(i)));
			ExcelUtil.writeData(testSheet, rowNum, 1, getEventLocation(events.get(i)));
			ExcelUtil.writeData(testSheet, rowNum, 2, getEventDate(events.get(i)));
			for (int j = 0; j < getEventTags(events.get(i)).size(); j++) {
				ExcelUtil.writeData(testSheet, rowNum, 3, getEventTags(events.get(i)).get(j));
				rowNum = rowNum + 1;
			}
		}
		ExcelUtil.writeData(testSheet, 1, 7, "Done");
		ExcelUtil.writeData(testSheet, 1, 8, DateTime.getCurrentTime());
	}
	
	public void expandEvents() {
		List<MyElement> moreLinks = driver.findMyWebElements(ExcelUtil.getData(testSheet, 2, 6));
		moreLinks.get(0).click();
		boolean result = driver.findMyWebElement("//a[text()=' Add event to your calendar']").exists();
		if (result) {
			logger.info("[Expand Events] More Link is working fine.");
		} else {
			logger.info("[Expand Events] More Link is NOT working!");
		}
		ExcelUtil.writeTestResult(testSheet, 2, 7, result);
	}
	
	public void searchEvents(String str) {
		driver.findMyWebElement(ExcelUtil.getData(testSheet, 3, 6)).input(str);
		driver.findMyWebElement(ExcelUtil.getData(testSheet, 4, 6)).click();
		DateTime.sleep(10000);
		boolean result = false;
		if (null != driver.findMyWebElement("//p[text()='No events scheduled.'")) {
			logger.info("[Search Events] No events scheduled.");
		} else {
			List<MyElement> events = driver.findMyWebElements(ExcelUtil.getData(testSheet, 1, 6));
			for(int i = 0; i < events.size(); i++) {
				logger.info("[Search Events] Get search result: " + getEventName(events.get(i)) + " " + getEventLocation(events.get(i)) + " " + getEventDate(events.get(i)));
			}
			result = true;
		}
		ExcelUtil.writeTestResult(testSheet, 3, 7, result);
	}
	
	public String getEventName(MyElement event) {
		String eventName = event.findMyWebElement("div[@class='eventContent vmore']/div[@class='event_title']/h2").getText();
		return eventName;
	}
	
	public String getEventLocation(MyElement event) {
		try {
			String eventLocation = event.findMyWebElement("div[@class='eventContent vmore']//p[@class='event_info']").getText();
			return eventLocation;
		} catch (NullPointerException e) {
			return "N/A";
		}
	}
	
	public String getEventDate(MyElement event) {
		String eventMonth = event.findMyWebElement("div[@class='eventDate']//div[@class='dateMonth']").getText();
		String eventDay = event.findMyWebElement("div[@class='eventDate']//div[@class='dDay']").getText();
		String eventDate = eventMonth + " " + eventDay;
		return eventDate;
	}
	
	public List<String> getEventTags(MyElement event) {
		List<MyElement> tagElement = event.findMyWebElements("div[@class='eventContent vmore']//a[@class='tagLink']");
		List<String> tags = new ArrayList<String>();
		for (int p = 0; p < tagElement.size(); p++) {
			if(!"".equals(tagElement.get(p).getText())) {
				tags.add(tagElement.get(p).getText());
			}
		}
		return tags;
	}
	
	private void clearData() {
		int rownum = ExcelUtil.getSheetRowcount(testSheet);
		for (int i = 1; i < rownum; i++) {
			for(int j = 0; j < 4; j++) {
				ExcelUtil.writeData(testSheet, i, j, "");
			}
		}
	}
	
	public void getPage(String url) {
		String str = EnvironmentVariable.getUrl("BaseURL")+url;
		logger.info("URLURLURL: "+str);
		driver.get(str);
	}

}
