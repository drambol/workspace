package utility.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author Wenjuan.Zhou
 * @Purpose Get country for Automation testing
 */

public class PropertiesUtil {

	public static String getCountry() {

		String file = System.getProperty("user.dir") + "\\test-data\\env.properties";
		String str = "Country";
		
		return propertyParse(file, str);
	}
	
	public static String propertyParse(String file, String str) {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(file);
			prop.load(input);
			String country = prop.getProperty(str);
			return country;
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;	
	}
}
