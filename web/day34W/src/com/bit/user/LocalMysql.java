package com.bit.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalMysql {
	private static Connection conn;
	private LocalMysql() {}
	
	public static Connection getConnection() {
		try {
			if(conn == null || conn.isClosed()) {
				try {
					if(conn == null || conn.isClosed()) {
						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "");
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
