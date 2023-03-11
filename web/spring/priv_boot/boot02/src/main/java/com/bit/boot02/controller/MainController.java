package com.bit.boot02.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.boot02.model.BookDao;

@Controller
public class MainController {

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@GetMapping("/")
	public String index(Model model) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			model.addAttribute("bean", sqlSession.getMapper(BookDao.class).selectAll());
			return "index";
		}
		
	}
}
