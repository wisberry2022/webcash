package com.bit.boot03.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bit.boot03.model.vo.PersonVo;

@Mapper
public interface PersonDao {
	
	@Select("select * from person")
	List<PersonVo> findAll();
	
}
