package utility.tableUtility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseline.AutoContext;
import baseline.MyDriver;

public class MyTable {
	
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	protected WebElement table;
	
	public MyTable(By by) {
		table = driver.findElement(by);
		if (!table.isDisplayed()) {
			System.out.println("Table is not displayed on the page!");
		}
	}
	
	public MyTable(By by, MyDriver driver) {
		driver = AutoContext.otpTL.get();
		table = driver.findElement(by);
		if (!table.isDisplayed()) {
			System.out.println("Table is not displayed on the page!");
		}
	}
	
	public boolean exists() {
		return table.isDisplayed();
	}
	
	public WebElement cells(int rowNum, int colNum) {
		List<WebElement> rows = table.findElements(By.xpath("tbody/tr[./td or ./th]"));
		WebElement row = rows.get(rowNum);
		List<WebElement> cols = row.findElements(By.xpath("th|td"));
		WebElement col = cols.get(colNum);
		return col;
	}

}
