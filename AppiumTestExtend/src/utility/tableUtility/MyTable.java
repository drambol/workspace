package utility.tableUtility;

import java.util.List;
import org.openqa.selenium.By;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.MyElement;
import pageObject.MyWebElement;
import utility.calc.Algorithm;

public class MyTable {
	
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	protected MyWebElement table;
	
	public MyTable(By by) {
		table = driver.findMyWebElement(by);
		if (!table.isDisplayed()) {
			System.out.println("Table is not displayed on the page!");
		}
		
	}
	
	public boolean exists() {
		return table.isDisplayed();
	}
	
	public MyElement cells(int rowNum, int colNum) {
		List<MyElement> rows = table.findMyWebElements(By.xpath("tbody/tr[./td or ./th]"));
		MyWebElement row = rows.get(rowNum);
		List<MyElement> cols = row.findMyWebElements(By.xpath("th|td"));
		MyElement col = cols.get(colNum);
		return col;
	}
	
	public int getRowCount() {
		List<MyElement> rows = table.findMyWebElements(By.xpath("tbody/tr[./td or ./th]"));
    	return rows.size();
    }
	
	public String getRowCellData(String str, int strColNum, int targetColNum) {
		int rowCount = this.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			if (this.cells(i, strColNum).getText().equalsIgnoreCase(str)) {
				return this.cells(i, targetColNum).getText();
			}
		}
		return null;
	}
	
	public String[] getRowCellDatas(String str, int strColNum, int targetColNum) {
		int rowCount = this.getRowCount();
		int p = 0;
		String[] myArray = new String[rowCount];
		for (int i = 0; i < rowCount; i++) {
			if (this.cells(i, strColNum).getText().equalsIgnoreCase(str)) {
				myArray[p] = this.cells(i, targetColNum).getText();
				p = p + 1;
			}
		}
		String[] newArray = new String[p];
		for (int j = 0; j < p; j++) {
			newArray[j] = myArray[j];
		}
		return newArray;
	}
	
	public int getMaxRow(int colNum) {
		int rowCount = this.getRowCount();
		int p = 0;
		String cellString;
		long[] number = new long[rowCount];
		for (int i = 0; i < rowCount; i++) {
			cellString = this.cells(i, colNum).getText();
			try {
				number[p] = Long.parseLong(cellString);
			} catch (NumberFormatException e) {
				System.out.println(cellString + " cannot be converted to a digital.");
			}
		}
		return Algorithm.getMaximumOrder(number);
	}
	
	public int getMinRow(int colNum) {
		int rowCount = this.getRowCount();
		int p = 0;
		String cellString;
		long[] number = new long[rowCount];
		for (int i = 0; i < rowCount; i++) {
			cellString = this.cells(i, colNum).getText();
			try {
				number[p] = Long.parseLong(cellString);
			} catch (NumberFormatException e) {
				System.out.println(cellString + " cannot be converted to a digital.");
			}
		}
		return Algorithm.getMinimumOrder(number);
	}

}
