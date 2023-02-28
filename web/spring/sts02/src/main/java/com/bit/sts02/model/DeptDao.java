package com.bit.sts02.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public interface DeptDao {
	void insertOne(DeptVo bean);
	List<DeptVo> findAll();
	DeptVo findOne(int deptno);
	int updateOne(DeptVo bean);
	int deleteOne(int deptno);
}
