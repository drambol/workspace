package pageObject;

import org.openqa.selenium.support.PageFactory;

import baseline.AutoContext;
import baseline.MyDriver;

/**
 * 
 * @author Wenjuan.Zhou
 * @Purpose new a instance of a page and let the test case to call the methods
 *          of the page.
 */

public class PageLoader {

	@SuppressWarnings("unchecked")
	public static <T extends PageObject> T load(Class<T> pageClass){
		T pageObject = null;
		try {
			if (!pageClass.isMemberClass()) {
				pageObject = pageClass.newInstance();
			} else {
				pageObject = (T) pageClass.getConstructors()[0]
						.newInstance(pageClass.getDeclaringClass().newInstance());
			}
		} catch (Exception e) {
		}
		return load(pageObject);
	}

	/**
	 * Binds fields of <code>PageObject</code> with <code>WebDriver</code>.
	 * Invokes <code>PageLoadListener</code>s. Initiate page elements
	 * 
	 * @throws InterruptedException
	 */
	
	 public static <T extends PageObject> T load(T pageObject) {
		 MyDriver webDriver = AutoContext.myWebDriverTL.get();
		 PageFactory.initElements(webDriver, pageObject);
		 return pageObject;
	 }
}
