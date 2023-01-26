package com.bit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalSql {
	private static Connection conn;
	private LocalSql() {}
	
	public static Connection getConnection() {
		try{
			if(conn == null || conn.isClosed()) {
				Class.forName("com.mysql.jdbc.cj.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lecture", "root", "");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
