package com.study.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDao extends JdbcDaoSupport implements UserDaoImpl {
	@Override
	public void insertOne(UserVo bean) {
		String sql = "insert into userinfo values (?,?)";
		getJdbcTemplate().update(sql, bean.getId(), bean.getPwd());
	}
	
	@Override
	public UserVo selectOne(String id) {
		return null;
	}
	
	@Override
	public boolean isLogin(UserVo bean) {
		boolean isLogined = false;
		String sql = "select id from userinfo where id=? and pwd=?";
		
		UserVo result = getJdbcTemplate().queryForObject(sql, new RowMapper<UserVo>() {

			@Override
			public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new UserVo(rs.getString("id"), "0");
			}
			
		}, bean.getId(), bean.getPwd());
		
		if(result.getId() != null) isLogined = true;
		else return isLogined = false; 
	
		return isLogined;
	}
	
	@Override
	public List<UserVo> selectAll() {
		return null;
	}
	
	@Override
	public void updateOne(String id) {	}
	
	@Override
	public void deleteOne(String id) {	}

	
}
