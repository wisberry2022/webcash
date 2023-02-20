package com.bit.framework.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import com.bit.model.DeptDto;

public abstract class JdbcTemplate {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource dataSource = null;
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void setDataSource(DataSource source) {
		this.dataSource = source;
	}
	
	public int update(String sql, Object[] objs) {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i<objs.length; i++) {
				pstmt.setObject(i+1, objs[i]);	
			}
			
			return pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	public List queryForAll(String sql, Object[] arr) {
		List list = new ArrayList();
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i<arr.length; i++) {
				pstmt.setObject(i+1, arr[i]);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapper(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	
	public void close(Connection conn) throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	
	public abstract Object mapper(ResultSet rs) throws SQLException;
}
