package com.bit.stu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalMySql {
	private static Connection conn;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/webdb";
	// 객체 생성을 막는다
	private LocalMySql() {}
	
	public static Connection getConnection() {
		try {
			if(conn==null || conn.isClosed()) {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, "root", "");
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
