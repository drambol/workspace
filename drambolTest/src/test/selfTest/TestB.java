package test.selfTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestB {

	@Test
	public void firstTestCase() throws Exception {
		Thread.sleep(2000);
		System.out.println("im in first test case from ClassTwo Class");
	}

	@Test
	public void secondTestCase() throws Exception {
		Thread.sleep(500);
		System.out.println("im in second test case from ClassTwo Class");
		Assert.fail("Failing this Test");
	}

	@Test
	public void thirdTestCase() throws Exception {
		Thread.sleep(2000);
		System.out.println("im in third test case from ClassTwo Class");
	}

	@Test
	public void fourthTestCase() throws Exception {
		Thread.sleep(2000);
		System.out.println("im in fourth test case from ClassTwo Class");
	}

	@Test
	public void fifthTestCase() throws Exception {
		Thread.sleep(2000);
		System.out.println("im in fifth test case from ClassTwo Class");
	}

}
