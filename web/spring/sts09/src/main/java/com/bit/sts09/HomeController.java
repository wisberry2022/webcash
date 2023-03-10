package com.bit.sts09;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts09.model.DeptDao;
import com.bit.sts09.model.entity.DeptVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("list", sqlSession.getMapper(DeptDao.class).findAll());
		return "home";
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/")
	public String add(@ModelAttribute("bean") DeptVo bean) {
		sqlSession.getMapper(DeptDao.class).insertOne(bean);
		return "redirect:./";
	}
}
