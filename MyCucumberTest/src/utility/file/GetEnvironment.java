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

public class GetEnvironment {

	public static String getCountry() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(System.getProperty("user.dir") + "\\test-data\\env.properties");
			prop.load(input);
			String country = prop.getProperty("Country");
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
