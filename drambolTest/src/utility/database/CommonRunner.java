package utility.database;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;


/**
 * 
 * @author Wenjuan.Zhou
 * @Purpose Execute sql query
 */

public class CommonRunner {

	public static List<Map<String, Object>> execQuery(final String sql) throws Exception {
		return DBUtil.execSql(new SqlCallback<List<Map<String, Object>>>() {
			@Override
			public List<Map<String, Object>> exec(Connection conn) throws Exception {
				QueryRunner qr = new QueryRunner();
				ResultSetHandler<List<Map<String, Object>>> rsh = new MapListHandler();
				return qr.query(conn, sql, rsh);
			}
		});
	}

	public static int execUpdate(final String sql) throws Exception {
		return DBUtil.execSql(new SqlCallback<Integer>() {
			@Override
			public Integer exec(Connection conn) throws Exception {
				QueryRunner qr = new QueryRunner();
				return qr.update(conn, sql);
			}
		});

	}
}
