package utility.file;

import java.util.List;

import org.openqa.selenium.By;

public class StringUtil {

	public static String getXpathId(By by) {
		String xpathStr = by.toString();
		String idStr = "";
		if (xpathStr.indexOf("id: ") > 0) {
			String[] args = xpathStr.split("id: ");
			idStr = args[1];
		} else if (xpathStr.indexOf("@id='") > 0) {
			String[] args1 = xpathStr.split("@id='");
			String[] args2 = args1[1].split("'");
			idStr = args2[0];
		}
		return idStr;
	}

	public static String getXpathName(By by) {
		String xpathStr = by.toString();
		String nameStr = "";
		if (xpathStr.indexOf("name: ") > 0) {
			String[] args = xpathStr.split("name: ");
			nameStr = args[1];
		} else if (xpathStr.indexOf("@name='") > 0) {
			String[] args1 = xpathStr.split("@name='");
			String[] args2 = args1[1].split("'");
			nameStr = args2[0];
		}
		return nameStr;
	}
	
	public static String getXpathId(String str) {
		String idStr = "";
		if (str.indexOf("id: ") > 0) {
			String[] args = str.split("id: ");
			idStr = args[1];
		} else if (str.indexOf("@id='") > 0) {
			String[] args1 = str.split("@id='");
			String[] args2 = args1[1].split("'");
			idStr = args2[0];
		}
		return idStr;
	}

	public static String getXpathName(String str) {
		String nameStr = "";
		if (str.indexOf("name: ") > 0) {
			String[] args = str.split("name: ");
			nameStr = args[1];
		} else if (str.indexOf("@name='") > 0) {
			String[] args1 = str.split("@name='");
			String[] args2 = args1[1].split("'");
			nameStr = args2[0];
		}
		return nameStr;
	}
	
	public static boolean contains(String[] args, String str) {
		int count = args.length;
		for (int i = 0; i < count; i++) {
			if (str.equals(args[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean contains(List<String> args, String str) {
		int count = args.size();
		for (int i = 0; i < count; i++) {
			if (str.equals(args.get(i))) {
				return true;
			}
		}
		return false;
	}

}
