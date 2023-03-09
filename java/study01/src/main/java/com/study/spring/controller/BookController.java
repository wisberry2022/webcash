package com.study.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring.model.BookDao;
import com.study.spring.model.BookVo;

@Controller
@RequestMapping(value="/book")
public class BookController {
	
	@Autowired
	BookDao dao;
	
	@RequestMapping("/list")
	public String listControl(Model model) {
		model.addAttribute("list", dao.getAllBook());
		return "books/list";
	}
	
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public String detailControl(@RequestParam("num") int num, Model model) {
		model.addAttribute("book", dao.getBook(num));
		return "books/detail";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addControl() {
		return "books/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addControl(@ModelAttribute("bean") BookVo bean) {
		System.out.println(bean);
		dao.insertOne(bean);
		return "redirect:./list";
	}
}
