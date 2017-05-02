//package utility.database;
//
//import java.sql.Array;
//import java.sql.Blob;
//import java.sql.CallableStatement;
//import java.sql.Clob;
//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.DriverManager;
//import java.sql.NClob;
//import java.sql.PreparedStatement;
//import java.sql.SQLClientInfoException;
//import java.sql.SQLException;
//import java.sql.SQLWarning;
//import java.sql.SQLXML;
//import java.sql.Savepoint;
//import java.sql.Statement;
//import java.sql.Struct;
//import java.util.Map;
//import java.util.Properties;
//import java.util.concurrent.Executor;
//
//import utility.file.ExcelUtil;
//
///**
// * 
// * @author Wenjuan.Zhou
// * @Purpose Connect to DB2
// */
//
//public class DB2Connect implements Connection {
//
//	public static Connection connection() {
//		String jdbcClassName = "com.ibm.db2.jcc.DB2Driver";
//		String dbUrl = ExcelUtil.getData("dbUrl");	
//		String dbUserName = ExcelUtil.getData("dbUserName");
//		String dbPassword = ExcelUtil.getData("dbPassword");
//
//		Connection connection = null;
//		
//		try {
//			// Load class into memory
//			Class.forName(jdbcClassName);
//			// Establish connection
//			connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
//			return connection;
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (connection != null) {
//				System.out.println("Connected successfully22222222222222222.");
//			}
//		}
//		return connection;
//
//	}
//	
//	public static void disconnection(Statement statement, Connection connection){
//		
//		if (statement != null) {
//			try {
//				statement.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		if (connection != null) {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
//
//	@Override
//	public boolean isWrapperFor(Class<?> class1) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public <T> T unwrap(Class<T> class1) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Statement createStatement() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public PreparedStatement prepareStatement(String s) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public CallableStatement prepareCall(String s) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String nativeSQL(String s) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setAutoCommit(boolean flag) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean getAutoCommit() throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void commit() throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void rollback() throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void close() throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean isClosed() throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public DatabaseMetaData getMetaData() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setReadOnly(boolean flag) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean isReadOnly() throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void setCatalog(String s) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String getCatalog() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setTransactionIsolation(int i) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public int getTransactionIsolation() throws SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public SQLWarning getWarnings() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void clearWarnings() throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Statement createStatement(int i, int j) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public PreparedStatement prepareStatement(String s, int i, int j)
//			throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public CallableStatement prepareCall(String s, int i, int j)
//			throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Map<String, Class<?>> getTypeMap() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setHoldability(int i) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public int getHoldability() throws SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Savepoint setSavepoint() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Savepoint setSavepoint(String s) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void rollback(Savepoint savepoint) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Statement createStatement(int i, int j, int k) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public PreparedStatement prepareStatement(String s, int i, int j, int k)
//			throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public CallableStatement prepareCall(String s, int i, int j, int k)
//			throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public PreparedStatement prepareStatement(String s, int i)
//			throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public PreparedStatement prepareStatement(String s, int[] ai)
//			throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public PreparedStatement prepareStatement(String s, String[] as)
//			throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Clob createClob() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Blob createBlob() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public NClob createNClob() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public SQLXML createSQLXML() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isValid(int i) throws SQLException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void setClientInfo(String s, String s1)
//			throws SQLClientInfoException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setClientInfo(Properties properties)
//			throws SQLClientInfoException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String getClientInfo(String s) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Properties getClientInfo() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Array createArrayOf(String s, Object[] aobj) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Struct createStruct(String s, Object[] aobj) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setSchema(String s) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String getSchema() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void abort(Executor executor) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setNetworkTimeout(Executor executor, int i) throws SQLException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public int getNetworkTimeout() throws SQLException {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//}
