package page.Move;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import baseline.AutoContext;
import baseline.MyDriver;
import pageObject.PageObject;

public class PaymentHistoryPage implements PageObject{
	
	public final MyDriver driver = AutoContext.myWebDriverTL.get();
	static final Logger logger = LoggerFactory.getLogger(PaymentHistoryPage.class);

}
