package com.bit.sts05.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DeptDaoImpl implements DeptDao {
	JdbcTemplate jdbcTemplate;
	
	
	public DeptDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<DeptVo> findAll() {
		String sql = "select * from dept";
		return jdbcTemplate.query(sql, new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		});
	}

	@Override
	public DeptVo findObject(int pk) {
		String sql = "select * from dept where deptno=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
		}, pk);
	}

	@Override
	public void insertOne(DeptVo bean) {
		String sql = "insert into dept values((select num from dept_seq), ?, ?)";
		jdbcTemplate.update(sql, bean.getDname(), bean.getLoc());
	}

	@Override
	public void seqUpdateOne() {
		String sql = "update dept_seq set num=num+1";
		jdbcTemplate.update(sql);
	}
	
	@Override
	public int updateOne(DeptVo bean) {
		String sql = "update dept set dname=?, loc=? where deptno=?";
		return jdbcTemplate.update(sql, bean.getDname(), bean.getLoc(), bean.getDeptno());
	}

	@Override
	public int deleteOne(int pk) {
		String sql = "delete from dept where deptno=?";
		return jdbcTemplate.update(sql, pk);
	}

}
