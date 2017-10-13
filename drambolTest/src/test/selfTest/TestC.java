package test.selfTest;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestC {
	@Test
	public void firstTestCase() throws Exception {
		Thread.sleep(100);
		System.out.println("im in first test case from ClassThree Class");
	}

	@Test
	public void secondTestCase() throws Exception {
		Thread.sleep(5000);
		System.out.println("im in second test case from ClassThree Class");
		throw new SkipException("Skipping this test with exception");
	}

}
