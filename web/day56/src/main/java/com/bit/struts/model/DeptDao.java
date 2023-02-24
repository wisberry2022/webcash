package com.bit.struts.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DeptDao {
	DataSource dataSource;
	
	public DeptDao() {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setURL("jdbc:mysql://localhost:3306/lecture");
		ds.setUser("scott");
		ds.setPassword("tiger");
//		DataSource는 setter가 없기 때문에 직접 주입이 불가능하다. 그래서 MysqlDataSource를 별도로 생성하여 DB 정보를 넣은 뒤 대입해야한다
		dataSource = ds;
	}
	
	public List<DeptVo> findAll() throws SQLException {
		String sql = "select * from dept";
		List<DeptVo> list = new ArrayList<>();
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				list.add(new DeptVo(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")
				));
			}
		}
		
		return list;
	}
	
	public void insertOne(int deptno, String dname, String loc) throws SQLException {
		
		String sql = "insert into dept values(?,?,?)";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);	
		){
			pstmt.setInt(1,  deptno);
			pstmt.setString(2,  dname);
			pstmt.setString(3, loc);
			pstmt.executeUpdate();
		}
	}
	
	public DeptVo findOne(int deptno) throws SQLException {
		String sql = "select * from dept where deptno=?";
		try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);	
		){
			pstmt.setInt(1,  deptno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new DeptVo(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")
						);
			}
			
		}
		return null;
	}
}
