package utility.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import utility.file.ExcelUtil;

/**
 * 
 * @author Wenjuan.Zhou
 * @Purpose Setup DB connection
 */

public class DBUtil {
	private static BasicDataSource dataSource = null;

	public static void init() throws Exception {
		String jdbcClassName = "com.ibm.db2.jcc.DB2Driver";
		String dbUrl = ExcelUtil.getData("dbUrl");	
		String dbUserName = ExcelUtil.getData("dbUserName");
		String dbPassword = ExcelUtil.getData("dbPassword");

		if (dataSource != null) {
			try {
				dataSource.close();
			} catch (Exception e) {
				//
			}
			dataSource = null;
		}

		try {
			Properties p = new Properties();
			p.setProperty("driverClassName", jdbcClassName);
			p.setProperty("url", dbUrl);
			p.setProperty("password", dbPassword);
			p.setProperty("username", dbUserName);
			p.setProperty("maxActive", "30");
			p.setProperty("maxIdle", "10");
			p.setProperty("maxWait", "1000");
			p.setProperty("removeAbandoned", "false");
			p.setProperty("removeAbandonedTimeout", "120");
			p.setProperty("testOnBorrow", "true");
			p.setProperty("logAbandoned", "true");
			dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(p);

		} catch (Exception e) {
			//
		}
	}

	public static synchronized Connection getConnection() throws Exception {
		init();
		Connection conn = null;
		if (dataSource != null) {
			conn = dataSource.getConnection();
			System.out.println("DB is connected successfully.");
		}
		return conn;
	}

	/**
	 * close all db connections
	 * 
	 * @throws Exception
	 */
	public static void closeDataSources() throws Exception {
		dataSource.close();
		System.out.println("DB dataSource closed.");
	}

	public static void closeConn(Connection conn) throws Exception {
		conn.close();
		System.out.println("DB connection closed.");
	}

	public static <T extends Object> T execSql(SqlCallback<T> sc) throws Exception {
		Connection conn = null;

		try {
			conn = getConnection();
			T t = (T) sc.exec(conn);
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (conn != null) {
					try {
						conn.close();
						System.out.println("Connection closed.");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
}
