package utility.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseline.AutoContext;
import baseline.MyDriver;
import utility.dateTime.DateTime;

/**
 * 
 * @author Grace.Zhou
 * @purpose file utility
 */

public class FileUtility {

	public static File generateFile(String fileName, String location) {
		File file = new File(System.getProperty("user.dir") + "\\src\\xml\\" + fileName);
		if (file.exists()) {
			file.delete();
		}
		try {
			URL url = new URL(location);
			BufferedReader inputFile = new BufferedReader(new InputStreamReader(url.openStream()));
			OutputStreamWriter outputFile = new OutputStreamWriter(new FileOutputStream(file, true));
			String str = null;
			while ((str = inputFile.readLine()) != null) {
				outputFile.write(str);
			}
			outputFile.flush();
			outputFile.close();
			inputFile.close();
			return file;
		} catch (MalformedURLException x) {
			System.out.println("Wrong Address!");
		} catch (IOException xx) {
			System.out.println("IO Exception!");
			xx.printStackTrace();
		}
		return null;
	}

	public static File writeFile(String fileName, String fileContent) {
		File file = new File(System.getProperty("user.dir") + "\\src\\xml\\" + fileName);
		if (file.exists()) {
			file.delete();
		}
		try {
			OutputStreamWriter outputFile = new OutputStreamWriter(new FileOutputStream(file, true));
			outputFile.write(fileContent);
			outputFile.flush();
			outputFile.close();
			return file;
		} catch (MalformedURLException x) {
			System.out.println("Wrong Address!");
		} catch (IOException xx) {
			System.out.println("IO Exception!");
			xx.printStackTrace();
		}
		return null;
	}

	public static String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();

			}
			String everything = sb.toString();
			return everything;
		} finally {
			br.close();
		}
	}

	public static void createTestResult(String fileName) {
		File file = new File(System.getProperty("user.dir") + "\\logs\\" + fileName);
		file.getParentFile().mkdirs();
		try {
			OutputStreamWriter outputFile = new OutputStreamWriter(new FileOutputStream(file, true));
			outputFile.write("<html><body><h3 align=center>Automation Testing Results</h3></body></html><hr>");
			outputFile
					.write("<center><font face=verdana size=2><table border=1 cellspacing=0 width=1200 height=35><tr>");
			outputFile.write("<td width=20% bgcolor=#ddddff align=center><b>Test Case Name</b></td>");
			outputFile.write(
					"<td width=35% bgcolor=#ddddff align=center><b>Actual</b></td><td width=35% bgcolor=#ddddff align=center><b>Expected</b></td>");
			outputFile.write(
					"<td width=10% bgcolor=#ddddff align=center><b>Result</b></td></tr></table></font></center>");
			outputFile.write("\r\n");
			outputFile.flush();
			outputFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static File writeTestResult(String fileName, String str1, String str2, String str3) {
		File file = new File(System.getProperty("user.dir") + "\\logs\\" + fileName);
		XmlParser xmlParser = new XmlParser("runSuite\\Config.xml");
		String str = xmlParser.getNodeValue("TestCaseName");
		try {
			OutputStreamWriter outputFile = new OutputStreamWriter(new FileOutputStream(file, true));
			outputFile
					.write("<center><font face=verdana size=2><table border=1 cellspacing=0 width=1200 height=35><tr>");
			outputFile
					.write("<td width=20% bgcolor=yellow align=center><b><font color=blue>" + str + "</font></b></td>");
			outputFile.write("<td width=35% bgcolor=yellow align=center><b>" + str1 + "</b></td>");
			outputFile.write("<td width=35% bgcolor=yellow align=center><b>" + str2 + "</b></td>" + str3
					+ "</tr></table></font></center>");
			outputFile.write("\r\n");
			outputFile.flush();
			outputFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void takeScreenshot() throws IOException {
		MyDriver myDriver = AutoContext.myWebDriverTL.get();
		File scrFile = ((TakesScreenshot) myDriver.getOriginalDriver()).getScreenshotAs(OutputType.FILE);
		String fileName = DateTime.getCurrentTime() + ".png";
		File desfile = new File(System.getProperty("user.dir") + "\\screenshot\\" + fileName);
		desfile.getParentFile().mkdirs();
		try {
			FileUtils.copyFile(scrFile, desfile);
			System.out.println("***Placed screen shot in "+System.getProperty("user.dir") + "\\screenshot\\" + fileName+" ***");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
