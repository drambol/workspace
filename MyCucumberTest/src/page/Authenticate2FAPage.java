package page;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.PageObject;
import utility.file.ExcelUtil;

public class Authenticate2FAPage implements PageObject{
	
	public MyDriver myDriver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(Authenticate2FAPage.class);
	
	public void get2FAPage() {
		myDriver.get(ExcelUtil.getData("Get2FAMessages"));
		myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
