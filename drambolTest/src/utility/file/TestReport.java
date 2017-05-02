package utility.file;

import utility.dateTime.DateTime;

public class TestReport {
	
static String reportName = "";
	
	public TestReport() {
		if (reportName == "") {
			reportName = DateTime.getCurrentTime() + ".html";
			FileUtility.createTestResult(reportName);
		}
	}
	
	public static void writeReport(String actual, String expected, String result) {
		FileUtility.writeTestResult(reportName, actual, expected, result);
	}

}
