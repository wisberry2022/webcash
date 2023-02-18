package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.bit.util.LogState;

public class UserDao {
	private Connection conn;
	
	public UserDao() throws NamingException {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String isLogin(UserDto bean) throws SQLException {
		String sql = "select id from userinfo where id=? and pwd=?";
		
		try(
			Connection conn = this.conn;
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPwd());
			
			ResultSet rs =pstmt.executeQuery();
			
			if(rs.next()) {
				if(bean.getId().equals(rs.getString(1))) {
					rs.close();
					return new LogState(1).getState();
				}else {
					rs.close();
					return new LogState(2).getState();
				}
			}else {
				return new LogState(0).getState();
			}
		}
		
	}
	
	// 회원가입
	public int insertOne(Map<String, String[]> params) throws SQLException {
		String sql = "insert into userinfo(id, pwd, re, name, email) values (?,?,?,?,?)";
		
		List<String> values = new ArrayList<>();
		Set<String> names = params.keySet();
		Iterator<String> ite = names.iterator();
		while(ite.hasNext()) {
			String[] data = params.get(ite.next());
			values.add(data[0]);
		}

		try(
			Connection conn = this.conn;
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			for(int i = 1; i<=5; i++) {
				pstmt.setString(i, values.get(i-1));
			}

			return pstmt.executeUpdate();
		}
	}
}
