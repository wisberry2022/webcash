package com.study.spring.model;

import java.util.List;

public interface UserDaoImpl {

	void insertOne(UserVo bean);

	UserVo selectOne(String id);

	List<UserVo> selectAll();

	void updateOne(String id);

	void deleteOne(String id);

}