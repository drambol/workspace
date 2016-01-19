package utility.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utility.dateTime.DateTime;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ExcelUtil {
	
	//Note: All excel relevant count will initial from 0!!!
	static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
	public final static File file = new File(System.getProperty("user.dir") + "\\test-data\\SPX.xls");
	
	public static String getData(String sheetName, int x, int y){
		try {
			Workbook book = Workbook.getWorkbook(file);
			Sheet sheet = book.getSheet(sheetName);
			Cell cell = sheet.getCell(y, x);
			return cell.getContents();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getElementCommand(String sheetName, String elementName){
		try {
			Workbook book = Workbook.getWorkbook(file);
			Sheet sheet = book.getSheet(sheetName);
			int maxRow = sheet.getRows();
			int rowNum = 0;
			for (int i=1;i<maxRow;i++){
				Cell cell1 = sheet.getCell(0, i);
				if(cell1.getContents().equalsIgnoreCase(elementName)){
					rowNum = i;
					break;
				}
			}
			Cell cell2 = sheet.getCell(1, rowNum);
			return cell2.getContents();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getElementXpath(String sheetName, String elementName) {
		try {
			Workbook book = Workbook.getWorkbook(file);
			Sheet sheet = book.getSheet(sheetName);
			int maxRow = sheet.getRows();
			int rowNum = 0;
			for (int i = 1; i < maxRow; i++) {
				Cell cell1 = sheet.getCell(0, i);
				if (cell1.getContents().equalsIgnoreCase(elementName)) {
					rowNum = i;
					break;
				}
			}
			Cell cell2 = sheet.getCell(2, rowNum);
			return cell2.getContents();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getExpectedResult(String sheetName, String elementName) {
		try {
			Workbook book = Workbook.getWorkbook(file);
			Sheet sheet = book.getSheet(sheetName);
			int maxRow = sheet.getRows();
			int rowNum = 0;
			for (int i=1;i<maxRow;i++){
				Cell cell1 = sheet.getCell(0, i);
				if(cell1.getContents().equalsIgnoreCase(elementName)){
					rowNum = i;
					break;
				}
			}
			Cell cell2 = sheet.getCell(3, rowNum);
			return cell2.getContents();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void writeActualResult(String sheetName, String elementName, String result) {
		try {
			InputStream input = new FileInputStream(file);
			POIFSFileSystem filesystem = new POIFSFileSystem(input);
			HSSFWorkbook workbook = new HSSFWorkbook(filesystem);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			int maxRow = sheet.getLastRowNum();
			for (int i = 1; i < maxRow; i++) {
				HSSFRow row = sheet.getRow(i);
				HSSFCell cell = row.getCell(0);
				if (cell.getStringCellValue().equalsIgnoreCase(elementName)) {
					cell = row.getCell(4);
					if (null == cell) {
						cell = row.createCell(4);
					}
					cell.setCellValue(result);
					FileOutputStream output = new FileOutputStream(file);
					workbook.write(output);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeTestResult(String sheetName, int x, int y, boolean result) {
		String flag = "Pass";
		if (!result) {
			flag = "Fail";
		}
		try {
			InputStream input = new FileInputStream(file);
			POIFSFileSystem filesystem = new POIFSFileSystem(input);
			HSSFWorkbook workbook = new HSSFWorkbook(filesystem);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			HSSFRow row = sheet.getRow(x);
			if (null == row) {
				row = sheet.createRow(x);
			}
			HSSFCell cell1 = row.getCell(y);
			HSSFCell cell2 = row.getCell(y+1);
			if (null == cell1) {
				cell1 = row.createCell(y);
			}
			cell1.setCellValue(flag);
			if (null == cell2) {
				cell2 = row.createCell(y+1);
			}
			cell2.setCellValue(DateTime.getCurrentTime());
			FileOutputStream output = new FileOutputStream(file);
			workbook.write(output);
		} catch (IOException e) {
			logger.info("The target excel is in use, please close it and try again.");
		}
	}
	
	public static void writeData(String sheetName, int x, int y, String data) {
		try {
			InputStream input = new FileInputStream(file);
			POIFSFileSystem filesystem = new POIFSFileSystem(input);
			HSSFWorkbook workbook = new HSSFWorkbook(filesystem);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			HSSFRow row = sheet.getRow(x);
			if (null == row) {
				row = sheet.createRow(x);
			}
			HSSFCell cell = row.getCell(y);
			if (null == cell) {
				cell = row.createCell(y);
			}
			cell.setCellValue(data);
			FileOutputStream output = new FileOutputStream(file);
			workbook.write(output);
		} catch (IOException e) {
			logger.info("The target excel is in use, please close it and try again.");
		}
	}
	
	public static int getSheetRowcount(String sheetName) {
		try {
			Workbook book = Workbook.getWorkbook(file);
			Sheet sheet = book.getSheet(sheetName);
			return sheet.getRows();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (Integer) null;
	}

}
