package com.study.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BookDao extends JdbcDaoSupport implements BookDaoImpl {

	@Override
	public List<BookVo> getAllBook() {
		String sql = "select * from book";
		return getJdbcTemplate().query(sql, new RowMapper<BookVo>() {
			@Override
			public BookVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new BookVo(rs.getInt("num"), rs.getString("name"), rs.getString("author"), rs.getDate("publish"));
			}
		});
	}

	@Override
	public BookVo getBook(int num) {
		String sql = "select num, name, author, publish from book where num=?";
		return getJdbcTemplate().queryForObject(sql, new RowMapper<BookVo>() {

			@Override
			public BookVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new BookVo(rs.getInt("num"), rs.getString("name"), rs.getString("author"), rs.getDate("publish"));
			}
			
		}, num);
	}

	@Override
	public void insertOne(BookVo bean) {
		String sql = "insert into book(num, name, author, publish) values(?,?,?,now())";
		getJdbcTemplate().update(sql, bean.getNum(), bean.getName(), bean.getAuthor());
	}

}
