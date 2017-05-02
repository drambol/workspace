package utility.tools;

import java.io.IOException;

public class CMD {
	
	public static void killProcess(String str) {
	    Runtime rt = Runtime.getRuntime();
	    try {
	        rt.exec("taskkill /F /IM "+ str +".exe");
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

}
