package com.study.spring.model;

import java.util.List;

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
	public List<UserVo> selectAll() {
		return null;
	}
	
	@Override
	public void updateOne(String id) {	}
	
	@Override
	public void deleteOne(String id) {	}
}
