package pageObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class MyPageFactory{
	/**
	 * Initialize the pageObject with input pageObject class
	 * @param <T>
	 * @param driver
	 * @param pageClassToProxy
	 * @return
	 */
	public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
		T page = instantiatePage(driver, pageClassToProxy);
		initElements(driver, page);
		return page;
	}
	/**
	 * Initialize all the field of one page object 
	 * with @FindBy tag whose type are "MyWebElement"
	 * @param driver
	 * @param page
	 */
	public static void initElements(WebDriver driver, Object page) {
		final WebDriver driverRef = driver;
		ElementLocatorFactory factoryRef = new DefaultElementLocatorFactory(driverRef);
		FieldDecorator decorator = new DefaultFieldDecorator(factoryRef);
		Class<?> proxyIn = page.getClass();
		while (proxyIn != Object.class) {
			proxyFields(decorator, page, proxyIn);
			proxyIn = proxyIn.getSuperclass();
		}
	}
	/**
	 * The logic to initialize the field whose type are MyWebElement
	 * @param decorator
	 * @param page
	 * @param proxyIn
	 */

	@SuppressWarnings("unchecked")
	private static void proxyFields(FieldDecorator decorator, Object page, Class<?> proxyIn) {
		Field[] fields = proxyIn.getDeclaredFields();
		for (Field field : fields) {
			
			Object value = decorator.decorate(page.getClass().getClassLoader(), field);
			
			// Cast the value to probable interface
			Object castValue = null;
			String fieldName = field.getType().getName();
			if(fieldName.contains("MyWebElement")){ // private WebElement xxx;
				castValue = new MyElement((WebElement)value);
			}else if(field.getType().getName().contains("WebElement")){ // private MyWebElement xxx;
				castValue = (WebElement)value;
			}else if(fieldName.contains("java.util.List")){ // private List<E> xxx;
				ParameterizedType pt = (ParameterizedType)field.getGenericType();
				String parameterName = pt.getActualTypeArguments()[0].toString();
				if (parameterName.contains("WebElement")){ // private List<WebElement> xxx;
					castValue = (List<WebElement>)value;
				}else if(parameterName.contains("MyWebElement")){ // private List<MyWebElement> xxx;
					List<WebElement> elements = (List<WebElement>)value;
					List<MyWebElement> myelements = new ArrayList<MyWebElement>();
					for(WebElement element : elements){
						myelements.add(new MyElement(element));
					}
					castValue = myelements;
				}
			}
			
			
			if (value != null && castValue != null) {
				try {
					field.setAccessible(true);
					field.set(page, castValue);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	/**
	 * Calling constructor to initialize page instace
	 * @param <T>
	 * @param driver
	 * @param pageClassToProxy
	 * @return
	 */
	private static <T> T instantiatePage(WebDriver driver, Class<T> pageClassToProxy) {
		try {
			try {
				Constructor<T> constructor = pageClassToProxy.getConstructor(WebDriver.class);
				return constructor.newInstance(driver);
			} catch (NoSuchMethodException e) {
				return pageClassToProxy.newInstance();
			}
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}