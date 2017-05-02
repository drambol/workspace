package utility.ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

import utility.file.ExcelUtil;

public class FtpConnect {
	 public static void main(String[] args) throws IOException {
	 FTPClient client = new FTPClient();
	 
	 client.connect(ExcelUtil.getData(8, 2));
	 System.out.println("Connected");
	 boolean login = client.login(ExcelUtil.getData(9, 2), ExcelUtil.getData(10, 2));  
//	 int reply = client.getReplyCode(); 
//	 System.out.println("Reply Code:" + reply);
	
	 if (login) {
	 System.out.println("Login success...");
	 boolean logout = client.logout();
	 if (logout) {
	 System.out.println("Logout from FTP server...");
	 }
	 } else {
	 System.out.println("Login fail...");
	 }
	 client.disconnect();
	 }

	}
