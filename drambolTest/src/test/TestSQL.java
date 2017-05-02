package test;

import java.util.List;
import java.util.Map;

import utility.database.SQL;

public class TestSQL {

	public static void main(String[] args) throws Exception {

		// SQL sql = new SQL();
		// sql.getUserInfo(ExcelUtil.getData("UserName"));

		List<Map<String, Object>> rs = SQL.getUserName();
		String userName = rs.get(0).toString();
		System.out.println(userName);

	}

}
