package com.bit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RoomDao {
	private Connection conn;
	
	public RoomDao() throws NamingException {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<RoomDto> getFloorRoom(int floor) throws SQLException {
		List<RoomDto> list = new ArrayList<>();
		
		String sql = "select a.typenum, a.roomtype, a.roomname, a.maxnum, a.price, b.num ";
		sql += "from roomtype as a join room as b on a.typenum = b.typenum ";
		sql += "where b.num Like ?";
		
		try(
			Connection conn = this.conn;
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		){
			pstmt.setString(1, floor + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RoomDto bean = new RoomDto();
				bean.setRoomtype(rs.getString(2));
				bean.setRoomname(rs.getString(3));
				bean.setMaxnum(rs.getInt(4));
				bean.setPrice(rs.getInt(5));
				bean.setNum(rs.getInt(6));
				list.add(bean);
			}
		}
		
		return list;
	}
	
	
	public List<RoomDto> getInfoData() throws SQLException {
		List<RoomDto> list = new ArrayList<>();
		
		String sql = "select typenum, roomtype, roomname, maxnum, price from roomtype";
		
		try(
			Connection conn = this.conn;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				RoomDto bean = new RoomDto();
				bean.setTypenum(rs.getInt(1));
				bean.setRoomtype(rs.getString(2));
				bean.setRoomname(rs.getString(3));
				bean.setMaxnum(rs.getInt(4));
				bean.setPrice(rs.getInt(5));
				list.add(bean);
			}
		}
		
		return list;
	}
	
	
	public List<RoomDto> getData(int cnt) throws SQLException {
		List<RoomDto> beanList = new ArrayList<>();
		
		String sql = "select a.num, b.roomtype, b.roomname, b.maxnum, b.price from room as a join roomtype as b on a.typenum = b.typenum limit ?";
		
		try(
			Connection conn = this.conn;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
		){
			pstmt.setInt(1, cnt);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				RoomDto bean = new RoomDto();
				bean.setNum(rs.getInt(1));
				bean.setRoomtype(rs.getString(2));
				bean.setRoomname(rs.getString(3));
				bean.setMaxnum(rs.getInt(4));
				bean.setPrice(rs.getInt(5));
				beanList.add(bean);
			}
		}
		
		return beanList;
		
	}
	
	
}
