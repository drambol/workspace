package pageObject;

import org.openqa.selenium.WebDriver;

import baseline.AutoContext;
import pageObject.PageLoader;
import pageObject.PageObject;

public class PageLoader {
	/**
	 * Binds fields of <code>PageObject</code> with <code>WebDriver</code>.
	 * Invokes <code>PageLoadListener</code>s.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T extends PageObject> T load(Class<T> pageClass) {
		T pageObject = null;
		try {
			if (!pageClass.isMemberClass()) {
				pageObject = pageClass.newInstance();
			} else {
				pageObject = (T) pageClass.getConstructors()[0]
						.newInstance(pageClass.getDeclaringClass()
								.newInstance());
			}
		} catch (Exception e) {
		}
		return load(pageObject);
	}

	/**
	 * Binds fields of <code>PageObject</code> with <code>WebDriver</code>.
	 * Invokes <code>PageLoadListener</code>s.
	 * 
	 */
	public static <T extends PageObject> T load(T pageObject) {
		WebDriver webDriver = AutoContext.webDriverTL.get();
		MyPageFactory.initElements(webDriver, pageObject);
		return pageObject;
	}
}