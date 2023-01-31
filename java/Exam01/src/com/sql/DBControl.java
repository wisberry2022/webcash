package com.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBControl {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	private DBControl() {}
	
	public static void insertData(String userid, String pwd, String email, byte typeid) {
		conn = DBClass.getConnection();
		String sql = "insert into userinfo values(";
		sql += "'" + userid+ "', '" + pwd + "', '" + email + "', now(), " + typeid + ")";
		System.out.println(sql);
		if(conn != null) {
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			return;
		}
		try {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean searchData(String userid, String pwd) {
		boolean Result = false;
		conn = DBClass.getConnection();
		String sql = "select count(user_id) as result from userinfo where user_id='" + userid + "' AND pwd = '" + pwd + "'";
		System.out.println(sql);
		if(conn != null) {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					if(rs.getInt(1) == 1) Result = true;
					else Result = false;
				}else {
					Result = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			return Result;
		}
		return Result;
	}
}
