package testCase;

import org.testng.annotations.Test;
import testCase.BaseCaseTemplate;

public class TestCaseEnd extends BaseCaseTemplate {
	
	@Test
	public void testEnd() {
		closeDown();
	}

}