package utility.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtil {

	public final static File file = new File(System.getProperty("user.dir") + "\\test-data\\data.xls");

	public static String getDataBySheetName(String sheetName, int x, int y) {
		try {
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(sheetName);
			// get row x and column y
			Cell cell = sheet.getCell(y, x);
			return cell.getContents();
		} catch (BiffException e) {

		} catch (IOException e) {

		}
		return null;
	}

	// get data from xls file by row x and column y
	public static String getData(int x, int y) {
		try {
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(PropertiesUtil.getCountry());
			// get row x and column y
			Cell cell = sheet.getCell(y, x);
			return cell.getContents();
		} catch (BiffException e) {

		} catch (IOException e) {

		}
		return null;
	}

	public static String getData(String str) {
		try {
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(PropertiesUtil.getCountry());
			// Loop over the sheet
			for (int j = 0; j < sheet.getColumns(); j++) {
				for (int i = 0; i < sheet.getRows(); i++) {
					Cell cell = sheet.getCell(j, i);
					if (str.equals(cell.getContents())) {
						Cell targetCell = sheet.getCell(j + 1, i);
						return targetCell.getContents();
					}
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {

		}
		return null;
	}
	
	// get work book by file name
		public static String getData(File file, String str) {
			try {
				Workbook workbook = Workbook.getWorkbook(file);
				Sheet sheet = workbook.getSheet(PropertiesUtil.getCountry());
				// Loop over the sheet
				for (int j = 0; j < sheet.getColumns(); j++) {
					for (int i = 0; i < sheet.getRows(); i++) {
						Cell cell = sheet.getCell(j, i);
						if (str.equals(cell.getContents())) {
							Cell targetCell = sheet.getCell(j + 1, i);
							return targetCell.getContents();
						}
					}
				}
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {

			}
			return null;
		}

	public static String getHSSFData(String sheetName, int x, int y) {
		try {
			InputStream inp = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(inp);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			// get row x and column y
			HSSFRow row = sheet.getRow(x);
			HSSFCell cell = row.getCell(y);
			return cell.getStringCellValue();
		} catch (IOException e) {

		}
		return null;
	}

}
