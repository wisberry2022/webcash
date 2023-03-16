package com.bit.boot03.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.boot03.model.PersonDao;

@Controller
public class RootController {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@GetMapping("/")
	public String index(Model model) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		) {
			model.addAttribute("list", sqlSession.getMapper(PersonDao.class).findAll());
		}
		return "index";
	}
}
