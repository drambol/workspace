package pageObject;

import org.openqa.selenium.support.PageFactory;

import baseline.AutoContext;
import baseline.MyDriver;

/**
 * 
 * @author Wenjuan.Zhou
 * @Purpose new a instance of a page and let the test case to call the methods of the page.
 */

public class PageLoader {
	
	@SuppressWarnings("unchecked")
	public static <T extends PageObject> T load(Class<T> pageClass) {
		T pageObject = null;
		try {
			if (!pageClass.isMemberClass()) {
				pageObject = pageClass.newInstance();
			} else {
				pageObject = (T) pageClass.getConstructors()[0].newInstance(pageClass.getDeclaringClass().newInstance());
			}
		} catch (Exception e) {
		}
		return load(pageObject);
	}

	/**
	 * Binds fields of PageObject with WebDriver.
	 * Invokes PageLoadListeners.
	 * Initiate page elements
	 */
//	public static <T extends PageObject> T load(T pageObject) {
//		WebDriver webDriver = AutoContext.webDriverTL.get();
//		PageFactory.initElements(webDriver, pageObject);
//		return pageObject;
//	}
	
	public static <T extends PageObject> T load(T pageObject) {
		MyDriver myDriver = AutoContext.myWebDriverTL.get();
		MyPageFactory.initElements(myDriver, pageObject);
		return pageObject;
	}
}
