package com.study.spring.model;

import java.util.List;

public interface BookDaoImpl {

	public List<BookVo> getAllBook();
	public BookVo getBook(int num);
	
}
