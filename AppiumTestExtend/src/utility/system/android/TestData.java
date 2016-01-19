package utility.system.android;

import utility.system.WindowsProcess;

public class TestData {
	
	protected static String filePath = System.getProperty("user.dir") + "\\src\\apk";
	protected static String command;
	
	public static void copyApk() {
		command = "cmd /c copy " + filePath + "\\buildPath\\*.apk " + filePath;
		System.out.println(command);
		WindowsProcess.runProcess(command, 1);
		command = "cmd /c ren " + filePath + "\\*.apk " + "Mozy.apk";
		System.out.println(command);
		WindowsProcess.runProcess(command, 1);
	}
	
	public static void deleteApk() {
		command = "cmd /c del " + filePath + "\\*.apk /F";
		System.out.println(command);
		WindowsProcess.runProcess(command, 1);
	}
	
	public static void prepareApk() {
		deleteApk();
		copyApk();
	}

}
