package utility.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseline.AutoContext;
import baseline.MyDriver;
import utility.dateTime.DateTime;


public class ScreenshotListener implements ITestListener{
	
    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	takeScreenShot();
    }
    
    public void takeScreenShot() {
    	MyDriver myDriver = AutoContext.myWebDriverTL.get();
    	File scrFile = ((TakesScreenshot) myDriver.getOriginalDriver()).getScreenshotAs(OutputType.FILE);
    	String fileName = DateTime.getCurrentTime() + ".png";
    	File desfile = new File(System.getProperty("user.dir") + "\\screenshot\\" + fileName);
    	desfile.getParentFile().mkdirs();
            try {
            	FileUtils.copyFile(scrFile, desfile);
				System.out.println("***Placed screen shot in "+System.getProperty("user.dir") + "\\screenshot\\" + fileName+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
	public void onFinish(ITestContext context) {}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
