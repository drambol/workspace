package ken;

import java.io.*;
import java.net.*;

public class PageSave {
	
	public static void main(String arge[]) {
		String fileName = "test.xml";
		File file = new File(System.getProperty("user.dir") + "\\src\\xml\\" + fileName);
		if (file.exists()) {
			file.delete();
		}
		try {
			URL url = new URL("http://localhost/getEventsGeneric.xml");
			BufferedReader b1 = new BufferedReader(new InputStreamReader(url.openStream()));
			OutputStreamWriter b2 = new OutputStreamWriter(new FileOutputStream(file, true));
			String str = null;
			while ((str = b1.readLine()) != null) {
				b2.write(str);
				System.out.println(str);
			}
			b2.flush();
			b2.close();
			b1.close();
		} catch (MalformedURLException x) {
			System.out.println("Wrong Address!");
		} catch (IOException xx) {
			System.out.println("IO Exception!");
		}
	}

}
