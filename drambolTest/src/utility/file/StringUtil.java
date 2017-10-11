package utility.file;

import java.util.List;

import org.openqa.selenium.By;

public class StringUtil {

	// 以百度为例，xpathStr = By.id: su
	// args[0] = By. , args[1] = su
	public static String getXpathId(By by) {
		String xpathStr = by.toString();
		String idStr = "";
		if (xpathStr.indexOf("id: ") > 0) {//int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
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
	
	public static boolean compare(String str1, String str2) {
		if (str1.equals(str2)) {
			return true;
		} else {
			return false;
		}
	}

}
