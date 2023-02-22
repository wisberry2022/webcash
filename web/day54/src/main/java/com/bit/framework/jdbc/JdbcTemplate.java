package com.bit.framework.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

public class JdbcTemplate<T> {
	DataSource dataSource;
	
	public JdbcTemplate() {
		
	}
	
	public JdbcTemplate(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int update(String sql, Object...args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println(sql);
		System.out.println("template update: " + Arrays.toString(args));
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i<args.length; i++) {
				pstmt.setObject(i+1, args[i]);
			}

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	public T queryForObject(String sql, RowMapper<T> rowMapper, Object...args) {
		return queryForList(sql, rowMapper, args).get(0);
	}
	
	public List<T> queryForList(String sql, RowMapper<T> rows) {
		return queryForList(sql, rows, new Object[] {});
	}
	
	public List<T> queryForList(String sql, RowMapper<T> rows, Object...args) {
		List<T> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i<args.length; i++) {
				pstmt.setObject(i+1, args[i]);	
			}
			
			rs = pstmt.executeQuery();
			System.out.println("hi");
			while(rs.next()) {
				list.add(rows.mapper(rs));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
}
