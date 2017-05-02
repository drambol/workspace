package utility.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Wenjuan.Zhou
 * @Purpose sql queries
 */

public class SQL {

//	public static final Connection dbConnection = DB2Connect.connection();
//	public static Statement statement = null;
//
//	public void selectRecordsFromDbUserTable() throws SQLException {
//
//		String selectTableSQL = "select ID,USER_ID from SCBSEC.USER where USER_ID in ('121234341', 'myloginid')";
//
//		try {
//			statement = dbConnection.createStatement();
//			System.out.println(selectTableSQL);
//			ResultSet rs = statement.executeQuery(selectTableSQL);
//
//			while (rs.next()) {
//
//				String id = rs.getString("ID");
//				String user_id = rs.getString("USER_ID");
//				System.out.println("ID : " + id);
//				System.out.println("USER_ID : " + user_id);
//
//			}
//
//		} catch (SQLException e) {
//
//			System.out.println(e.getMessage());
//
//		} finally {
//
//			DB2Connect.disconnection(statement, dbConnection);
//
//		}
//
//	}
//
//	public void getUserInfo(String userId) throws SQLException {
//
//		String selectTableSQL = "select * from SCBSEC.USER where USER_ID = " + "'" + userId + "'";
//
//		try {
//			statement = dbConnection.createStatement();
//			System.out.println(selectTableSQL);
//			ResultSet rs = statement.executeQuery(selectTableSQL);
//
//			while (rs.next()) {
//
//				String user_id = rs.getString("USER_ID");
//				String name = rs.getString("NAME");
//				System.out.println("USER_ID : " + user_id);
//				System.out.println("NAME : " + name);
//
//			}
//
//		} catch (SQLException e) {
//
//			System.out.println(e.getMessage());
//
//		} finally {
//
//			DB2Connect.disconnection(statement, dbConnection);
//
//		}
//
//	}

	public static List<Map<String, Object>> getUserName() throws Exception {
		String query = "select ID,USER_ID from SCBSEC.USER";
		return CommonRunner.execQuery(query);
	}

}
