package utility.calc;

import org.testng.Assert;

import utility.file.TestReport;

public class MyAssert {
	public static void assertEqual(Object actual, Object expected) {
		String result;
		try {
			Assert.assertEquals(actual, expected);
			result = "<td width=10% bgcolor=green align=center><b>PASS</b></td>";
		} catch (AssertionError e) {
			result = "<td width=10% bgcolor=red align=center><b>FAIL</b></td>";
		}
		TestReport.writeReport(actual.toString(), expected.toString(), result);
	}
	
	public static void assertTrue(boolean condition, String message) {
		String result;
		try {
			Assert.assertTrue(condition);
			result = "<td width=10% bgcolor=green align=center><b>PASS</b></td>";
		} catch (AssertionError e) {
			result = "<td width=10% bgcolor=red align=center><b>FAIL</b></td>";
		}
		TestReport.writeReport("N/A", message, result);
	}

}
