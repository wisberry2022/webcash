package com.bit.boot02.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.boot02.model.entity.BookVo;

@Mapper
public interface BookDao {

	@Select("select * from book")
	List<BookVo> selectAll();

	@Select("select num,name,author,publish,uploadfile from book where num=#{num} ")
	BookVo selectOne(int num);
	
	@Insert("insert into book(name, author, publish, uploadfile) values(#{name}, #{author}, now(), #{uploadFile})")
	void insertOne(String name, String author, String uploadFile);

	@Update("update book set name=#{name}, author=#{author}, uploadfile=#{uploadFile} where num=#{num}")
	void updateOne(BookVo bookVo);

	@Delete("delete from book where num=#{num} ")
	void deleteOne(int num);	
}
