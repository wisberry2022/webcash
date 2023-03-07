package com.study.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring.model.UserDao;
import com.study.spring.model.UserVo;

@Controller
public class LoginController {
	@Autowired
	UserDao dao;
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/signin") 
	public String loginControl() {
		
		return "login/signin";
	}
	
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String SignInControl(@RequestParam("id") String id, @RequestParam("pwd") String pwd, HttpServletRequest req) {
		if(dao.isLogin(new UserVo(id, pwd))) {
			HttpSession ses = req.getSession();
			ses.setAttribute("uid", id);
			ses.setMaxInactiveInterval(30*60);
			return "redirect:/";	
		}
		return "redirect:/err/signfail";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String SignUpControl() {
		return "/login/signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String SignUpControl(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		dao.insertOne(new UserVo(id, pwd));
		return "redirect:/";
	}
	
	@RequestMapping(value="/signout", method=RequestMethod.GET)
	public String SignOutControl(HttpServletRequest req) {
		HttpSession ses = req.getSession();
		ses.invalidate();
		return "redirect:./";
	}
	
}
