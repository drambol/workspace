package test;

import org.testng.annotations.Test;

import utility.calc.MyAssert;

public class DrambolTest extends BaseCaseTemplate {

	@Test
	public void AppleTest() {
//		prepareTestReport(new Object() {
//		}.getClass().getEnclosingMethod().getName());
		int a = 1;
		int b = 2;
		int c = 1;// RDTB121
		MyAssert.assertEqual(a, b);
		MyAssert.assertEqual(a, c);
		MyAssert.assertTrue(a > b, "a > b");
		MyAssert.assertTrue(a < b, "a < b");
	}

	@Test
	public void OrangeTest() {
//		prepareTestReport(new Object() {
//		}.getClass().getEnclosingMethod().getName());
		String str1 = "Drambol is a good boy!";
		String str2 = "Partman is a good boy!";
		MyAssert.assertEqual(str1, str2);
		MyAssert.assertEqual(str1.length(), str2.length());
		MyAssert.assertTrue(str1.contains("Drambol"),
				"String contains 'Drambol'");
		MyAssert.assertTrue(str1.contains("Partman"),
				"String contains 'Partman'");
	}

}
