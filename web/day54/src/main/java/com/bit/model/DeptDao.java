package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;

import com.bit.framework.jdbc.JdbcTemplate;
import com.bit.framework.jdbc.RowMapper;

public class DeptDao {
	DataSource dataSource;
	RowMapper<DeptDto> mapper = new RowMapper() {
		@Override
		public DeptDto mapper(ResultSet rs) throws SQLException {
			return new DeptDto(rs.getInt("deptno"), rs.getString("dname"), rs.getString("ename"));
		}
	};
	
	public DeptDao() {
		JdbcDataSource jds = new JdbcDataSource();
		jds.setUrl("jdbc:h2:tcp://localhost/~/test");
		jds.setUser("sa");
		dataSource = jds;
	}
	
	public int insertOne(Object deptno, Object dname, Object loc) {
		String sql = "insert into dept (deptno, dname, nalja, ename) values (?,?,now(),?)";
		
		JdbcTemplate<DeptDto> template = new JdbcTemplate<>(dataSource);
		return template.update(sql, deptno, dname, loc);
	}
		
	public List<DeptDto> selectAll() {
		String sql = "select * from dept";
		JdbcTemplate<DeptDto> template = new JdbcTemplate<>(dataSource);

		return template.queryForList(sql, mapper);
	}
	
	public Object selectOne(int deptno) {
		String sql = "select * from dept where deptno=?";
		JdbcTemplate<DeptDto> template = new JdbcTemplate<>(dataSource);
		
		return template.queryForObject(sql, mapper, deptno);
	}
	
	public int updateOne(int deptno, String dname, String loc) {
		String sql = "update dept set dname=?, ename=? where deptno=?";
		JdbcTemplate<DeptDto> template = new JdbcTemplate<>(dataSource);
		return template.update(sql, dname, loc, deptno);
	}
}
