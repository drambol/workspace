package utility.sftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import utility.dateTime.DateTime;
import utility.file.ExcelUtil;

/**
 * 
 * @author Wenjuan.Zhou
 * @Purpose Connect to SFTP server
 */

public class SftpConnect {

	private static Session session() {

		String SFTPHOST = ExcelUtil.getData(8, 2);
		int SFTPPORT = 22;
		String SFTPUSER = ExcelUtil.getData(9, 2);
		String SFTPPASS = ExcelUtil.getData(10, 2);

		Session session = null;
		System.out.println("preparing the host information for sftp.");
		try {
			JSch jsch = new JSch();
			session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
			session.setPassword(SFTPPASS);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			config.put("PreferredAuthentications","publickey,keyboard-interactive,password");
			session.setConfig(config);
			session.connect();
			System.out.println("Host connected.");
			return session;
		} catch (Exception ex) {
			System.out.println("Exception found while tranfer the response.");
		}
		return session;
	}

	private static void breakConnect(ChannelSftp channelSftp, Channel channel, Session session) {
		channelSftp.exit();
		System.out.println("sftp Channel exited.");
		channel.disconnect();
		System.out.println("Channel disconnected.");
		session.disconnect();
		System.out.println("Host Session disconnected.");
	}

	public String copyFileToLocal(String workingDir, String fileName) {

		Channel channel = null;
		ChannelSftp channelSftp = null;
		String destFileName = "\\sftp-log\\"+ DateTime.getCurrentTime() + "-" + fileName;

		Session session = SftpConnect.session();
		try {
			channel = session.openChannel("sftp");
			channel.connect();
			System.out.println("sftp channel opened and connected.");
			channelSftp = (ChannelSftp) channel;
			System.out.println(channelSftp.pwd());
			channelSftp.cd(workingDir);
			System.out.println(channelSftp.pwd());
			channelSftp.get(fileName, destFileName);

		} catch (Exception ex) {

			System.out.println("Exception found while tranfer the response.");

		} finally {

			SftpConnect.breakConnect(channelSftp, channel, session);

		}
		return destFileName;
	}

}
