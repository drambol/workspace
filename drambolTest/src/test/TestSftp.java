package test;

import java.io.IOException;

import utility.file.FileUtility;
import utility.sftp.SftpConnect;

public class TestSftp {
	
	public static void main(String[] args) throws IOException{
		SftpConnect connect = new SftpConnect();
		String destFileName = connect.copyFileToLocal("/IBM/websphere/apps/logs/OFPFOA_OTHERS/nfs-ofp","forms-all.log");
		String str = FileUtility.readFile(destFileName).split("2017-04-19")[1];
		System.out.println(str);
		String str2 = FileUtility.readFile(destFileName).split("2017-04-19")[1].split("cacheName]=")[1];
		System.out.println(str2);
	}

}
